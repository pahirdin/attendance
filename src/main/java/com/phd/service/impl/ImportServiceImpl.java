package com.phd.service.impl;

import com.phd.entity.*;
import com.phd.mapper.AdminInfoMapper;
import com.phd.mapper.CheckTempMapper;
import com.phd.mapper.ClassesMapper;
import com.phd.mapper.MajorMapper;
import com.phd.service.ICommomService;
import com.phd.service.IImportService;
import com.phd.service.IRedisService;
import com.phd.utils.CommonUtil;
import net.sf.jsqlparser.expression.StringValue;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pahaied
 * @date 2019/12/30 9:48
 */
@Service
@Transactional
public class ImportServiceImpl implements IImportService {
    @Autowired
    private AdminInfoMapper adminInfoMapper;
    @Autowired
    private CheckTempMapper checkTempMapper;
    @Autowired
    private ICommomService commomServiceImpl;
    @Autowired
    private IRedisService redisServiceImpl;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private ClassesMapper classesMapper;

    /**
     * 班级信息新增页面
     * @param inputStream 文件内容
     * @param originalFilename 文件名
     * @param recordId 流水号
     * @return Map<String,Object>
     * @throws Exception Exception
     */
    @Override
    public Map<String,Object> getAdminListByExcel(InputStream inputStream, String originalFilename, String recordId) throws Exception  {
        Map<String,Object> map = new HashMap<>();
        //获取文件内容
        List<List<Object>> fileList = CommonUtil.getFileList(inputStream, originalFilename);
        ArrayList<CheckTemp> infos = new ArrayList<>();
        //插入临时表
        insertTmpByAdminFileList(recordId, fileList, infos);
        //获取需要操作的数据
        List<CheckTemp> tempList = commomServiceImpl.queryTempListByRecordId(recordId,0);
        //校验并保存临时表
        checkAdminInfos(tempList,recordId);
        //成功的数据
//        List<CheckTemp> succlist = commomServiceImpl.queryTempListByRecordId(recordId,1);

        //临时表数据搬到管理员表
        int suc = checkTempMapper.moveTempToAdminInfoTable(recordId);
        int temp = checkTempMapper.addRolesByTemp(recordId);
        if(infos.size() == 0) {
            map.put("allerro","0");
        }
        map.put("tol",infos.size());
        map.put("erro",infos.size()-suc);
        map.put("recordid",recordId);
        map.put("suc",suc);
        return  map;
    }

    public void checkAdminInfos(List<CheckTemp> tempList, String recordId) {
        HashMap<Integer,String> college = commomServiceImpl.queryAllCollege();
        Map<String, String> nos = new HashMap<>();
        for(CheckTemp temp : tempList) {
            boolean tag = true;
            if(nos.containsKey(temp.getTno())) {
                tag = false;
                temp.setCheckinfo("该工号重复");
                temp.setCheccode(2);
            }
            if(tag) {
                String tname = temp.getTname();
                if("null".equals(tname)) {
                    tag = false;
                    temp.setCheccode(2);
                    temp.setCheckinfo("未填写姓名");
                }
            }
            if(tag) {
                String ttel = temp.getTtel();
                if("null".equals(ttel)) {
                    tag = false;
                    temp.setCheckinfo("未填写手机号");
                    temp.setCheccode(2);
                }
            }
            if(tag) {
                if (CommonUtil.isSpecialChar(temp.getTno())) {
                    tag = false;
                    temp.setCheckinfo("工号含有特殊字符");
                    temp.setCheccode(2);
                }
            }
            if (tag) {
                if(!CommonUtil.isTelNumber(temp.getTtel())) {
                    tag = false;
                    temp.setCheckinfo("手机号格式不正确");
                    temp.setCheccode(2);
                }
            }
            if(tag) {
                if(!college.values().contains(temp.getConame())) {
                    tag = false;
                    temp.setCheckinfo("未匹配到学院");
                    temp.setCheccode(2);
                }
            }
            if(tag) {
                nos.put(temp.getTno(),temp.getTno());
                temp.setCheccode(1);
                temp.setSpare1(CommonUtil.getKey(college,temp.getConame()));
            }
        }
        commomServiceImpl.saveTempTable(tempList);
        this.checkTempMapper.checkAdminNoRepeatByRecordId(recordId);
    }


    private void insertTmpByAdminFileList(String recordId, List<List<Object>> fileList, ArrayList<CheckTemp> infos) {
        //转实体集合
        for(List<Object> list : fileList) {
            if(list.size() < 4) {
                break;
            }
            CheckTemp temp = new CheckTemp();
            if(StringUtils.isBlank(String.valueOf(list.get(0)))) {
                break;
            }
            temp.setTno(String.valueOf(list.get(0)));
            temp.setTname(String.valueOf(list.get(1)));
            temp.setTtel(String.valueOf(list.get(2)));
            String pwd = "".equals(String.valueOf(list.get(3))) ? "123456" : String.valueOf(list.get(3));
            Object md = new Md5Hash(pwd).toString();

            temp.setTpwd(md.toString());
            temp.setConame(String.valueOf(list.get(4)));
            temp.setRecordid(recordId);
            temp.setCheccode(0);
            infos.add(temp);
        }
        //插入临时表
        if(!infos.isEmpty()) {
            checkTempMapper.insertBatch(infos);
        }
    }

    @Override
    public ExcelData getExcelData(String recordid) {
        CheckTempExample checkTempExample = new CheckTempExample();
        CheckTempExample.Criteria criteria = checkTempExample.createCriteria();
        criteria.andRecordidEqualTo(recordid);
        criteria.andCheccodeEqualTo(2);
        List<CheckTemp> list = checkTempMapper.selectByExample(checkTempExample);
        ExcelData data = new ExcelData();
        data.setName("error");
        List<String> titles = new ArrayList<>();
        titles.add("账号");
        titles.add("错误原因");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList<>();
        for (CheckTemp checkTemp : list) {
            ArrayList<Object> row = new ArrayList<>();
            row.add(checkTemp.getTno());
            row.add(checkTemp.getCheckinfo());
            rows.add(row);
        }
        data.setRows(rows);
        return data;
    }

    /**
     * 新增学生信息
     * @param inputStream 文件内容
     * @param originalFilename 文件名
     * @param recordId 流水号
     * @return map
     * @throws Exception 错误
     */
    @Override
    public Map<String, Object> getStudentListByExcel(InputStream inputStream, String originalFilename, String recordId) throws Exception {
        Map<String,Object> map = new HashMap<>();
        //获取文件内容
        List<List<Object>> fileList = CommonUtil.getFileList(inputStream, originalFilename);
        ArrayList<CheckTemp> infos = new ArrayList<>();
        //插入临时表
        insertTmpByStudentFileList(recordId, fileList, infos);
        //获取需要操作的数据
        List<CheckTemp> tempList = commomServiceImpl.queryTempListByRecordId(recordId,0);
        //校验并保存临时表
        checkStudetInfos(tempList,recordId);
        //成功的数据
//        List<CheckTemp> succlist = commomServiceImpl.queryTempListByRecordId(recordId,1);

        //临时表数据搬到学生信息表
        int suc = checkTempMapper.moveTempToStudentInfoTable(recordId);
        if(infos.size() == 0) {
            map.put("allerro","0");
        }
        map.put("tol",infos.size());
        map.put("erro",infos.size()-suc);
        map.put("recordid",recordId);
        map.put("suc",suc);
        return  map;
    }

    @Override
    public Map<String, Object> getClassListByExcel(InputStream inputStream, String originalFilename, String recordId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        //获取文件内容
        List<List<Object>> fileList = CommonUtil.getFileList(inputStream, originalFilename);
        ArrayList<CheckTemp> infos = new ArrayList<>();
        //数据入临时表
        insertTmpByClassFileList(recordId,fileList,infos);
        //获取临时表数据
        List<CheckTemp> tempList = commomServiceImpl.queryTempListByRecordId(recordId,0);
        //校验并保存临时表
        checkClassInfo(tempList,recordId);
        //根据校验通过的数据新增到班级表里
        int suc = checkTempMapper.moveTempToClassTable(recordId);
        if(infos.size() == 0) {
            map.put("allerro","0");
        }
        map.put("tol",infos.size());
        map.put("erro",infos.size()-suc);
        map.put("recordid",recordId);
        map.put("suc",suc);
        return map;
    }

    private void checkClassInfo(List<CheckTemp> tempList, String recordId) {
        HashMap<Integer,String> college = commomServiceImpl.queryAllCollege();
        Map<String, String> repeat = new HashMap<>();
        for(CheckTemp temp : tempList) {
            boolean tag = true;
            if(StringUtils.isEmpty(temp.getConame())) {
                tag = false;
                temp.setCheckinfo("未填写学院");
                temp.setCheccode(2);
            }
            if(tag && StringUtils.isBlank(temp.getSpare3())) {
                tag = false;
                temp.setCheckinfo("未填写专业");
                temp.setCheccode(2);
            }
            if(tag && StringUtils.isBlank(temp.getSpare4())) {
                tag = false;
                temp.setCheckinfo("未填写班级");
                temp.setCheccode(2);
            }
            if(tag) {
                if(repeat.containsKey(temp.getConame()+temp.getSpare3()+temp.getSpare4())) {
                    tag = false;
                    temp.setCheckinfo("该条数据重复");
                    temp.setCheccode(2);
                }
            }
            if(tag) {
                if(!college.values().contains(temp.getConame())) {
                    tag = false;
                    temp.setCheckinfo("未匹配到学院");
                    temp.setCheccode(2);
                }else {
                    temp.setSpare1(CommonUtil.getKey(college,temp.getConame()));
                }
            }
            if(tag) {
                Integer majorId = redisServiceImpl.getMajorByName(temp.getSpare3(),temp.getSpare1());
                //查询专业是否存在 存在设置专业id  不存在新增专业 并设置专业id
                if (majorId == null) {
                    Major major = new Major();
                    major.setCoid(temp.getSpare1());
                    major.setMname(temp.getSpare3());
                    //插入一条数据 并给major实体类的id 赋新增的主键
                    this.majorMapper.insertOne(major);
                    temp.setSpare2(major.getId());
                }else {
                    temp.setSpare2(majorId);
                }
            }
            if(tag) {
                ClassesExample classesExample = new ClassesExample();
                ClassesExample.Criteria criteria = classesExample.createCriteria();
                criteria.andMidEqualTo(temp.getSpare2());
                criteria.andCnameEqualTo(temp.getSpare4());
                List<Classes> classes = this.classesMapper.selectByExample(classesExample);
                if(classes.size() != 0) {
                    tag = false;
                    temp.setCheckinfo("班级已存在");
                    temp.setCheccode(2);
                }
            }
            if(tag) {
                repeat.put(temp.getConame()+temp.getSpare3()+temp.getSpare4(),temp.getConame()+temp.getSpare3()+temp.getSpare4());
                temp.setCheccode(1);
                temp.setSpare1(CommonUtil.getKey(college,temp.getConame()));
            }
        }
        commomServiceImpl.saveTempTable(tempList);
    }

    private void insertTmpByClassFileList(String recordId, List<List<Object>> fileList, ArrayList<CheckTemp> infos) {
        //转实体集合
        for(List<Object> list : fileList) {
            if(list.size() < 3) {
                break;
            }
            CheckTemp temp = new CheckTemp();
            if(StringUtils.isBlank(String.valueOf(list.get(0)))) {
                break;
            }
            //学院
            temp.setConame(String.valueOf(list.get(0)));
            //专业
            temp.setSpare3(String.valueOf(list.get(1)));
            //班级
            temp.setSpare4(String.valueOf(list.get(2)));

            temp.setRecordid(recordId);
            temp.setCheccode(0);
            infos.add(temp);
        }
        //插入临时表
        if(!infos.isEmpty()) {
            checkTempMapper.insertBatch(infos);
        }
    }

    private void checkStudetInfos(List<CheckTemp> tempList, String recordId) {
        HashMap<Integer,String> college = commomServiceImpl.queryAllCollege();
        Map<String, String> nos = new HashMap<>();
        for(CheckTemp temp : tempList) {
            boolean tag = true;
            if(nos.containsKey(temp.getTno())) {
                tag = false;
                temp.setCheckinfo("该学号重复");
                temp.setCheccode(2);
            }
            if(tag) {
                if (CommonUtil.isSpecialChar(temp.getTno())) {
                    tag = false;
                    temp.setCheckinfo("学号含有特殊字符");
                    temp.setCheccode(2);
                }
            }
            if(tag) {
                String tname = temp.getTname();
                if("null".equals(tname) || "".equals(tname)) {
                    tag = false;
                    temp.setCheccode(2);
                    temp.setCheckinfo("未填写学生姓名");
                }
            }
            if(tag) {
                String ttel = temp.getTtel();
                if("null".equals(ttel) || "".equals(ttel)) {
                    tag = false;
                    temp.setCheckinfo("未填写手机号");
                    temp.setCheccode(2);
                }
            }
            if (tag) {
                if(!CommonUtil.isTelNumber(temp.getTtel())) {
                    tag = false;
                    temp.setCheckinfo("手机号格式不正确");
                    temp.setCheccode(2);
                }
            }
            if (tag) {
                if ("null".equals(temp.getConame()) || "".equals(temp.getConame())) {
                    tag = false;
                    temp.setCheckinfo("未填写学院");
                    temp.setCheccode(2);
                }
            }
            if(tag) {
                if(!college.values().contains(temp.getConame())) {
                    tag = false;
                    temp.setCheckinfo("未匹配到学院");
                    temp.setCheccode(2);
                }else {
                    temp.setSpare1(CommonUtil.getKey(college,temp.getConame()));
                }
            }
            if(tag) {
                if("null".equals(temp.getSpare3()) || "".equals(temp.getSpare3())) {
                    tag = false;
                    temp.setCheckinfo("未填写专业");
                    temp.setCheccode(2);
                }
            }
            if(tag) {
                Integer majorId = redisServiceImpl.getMajorByName(temp.getSpare3(),temp.getSpare1());
                if (majorId == null) {
                    tag = false;
                    temp.setCheckinfo("未匹配到专业");
                    temp.setCheccode(2);
                }else {
                    temp.setSpare2(majorId);
                }
            }
            if(tag) {
                if("null".equals(temp.getSpare4()) || "".equals(temp.getSpare4())) {
                    tag = false;
                    temp.setCheckinfo("未填写班级");
                    temp.setCheccode(2);
                }
            }
            if(tag) {
                Integer cid = redisServiceImpl.getClassesIdByName(temp.getSpare4(),temp.getSpare2());
                if (null == cid) {
                    tag = false;
                    temp.setCheckinfo("未匹配到班级");
                    temp.setCheccode(2);
                }else {
                    temp.setSpare7(cid);
                }
            }
            if(tag) {
                nos.put(temp.getTno(),temp.getTno());
                temp.setCheccode(1);
            }
        }
        commomServiceImpl.saveTempTable(tempList);
        //去掉已存在的学号
        this.checkTempMapper.checkStudentNoRepeatByRecordId(recordId);
    }

    private void insertTmpByStudentFileList(String recordId, List<List<Object>> fileList, ArrayList<CheckTemp> infos) {
        //转实体集合
        for(List<Object> list : fileList) {
            if(list.size() < 7) {
                break;
            }
            CheckTemp temp = new CheckTemp();
            if(StringUtils.isBlank(String.valueOf(list.get(0)))) {
                break;
            }
            //学号
//            bd1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
            BigDecimal bd = new BigDecimal(String.valueOf(list.get(0)));
            String s = bd.toPlainString();
            temp.setTno(s);
            //姓名
            temp.setTname(String.valueOf(list.get(1)));
            //学院
            temp.setConame(String.valueOf(list.get(2)));
            //专业
            temp.setSpare3(String.valueOf(list.get(3)));
            //班级
            temp.setSpare4(String.valueOf(list.get(4)));
            //手机号
            temp.setTtel(String.valueOf(list.get(5)));
            //宿舍
            temp.setSpare5(String.valueOf(list.get(6)));
            //家长手机号
            temp.setSpare6(String.valueOf(list.get(7)));

            String pwd = "123456";
            Object md = new Md5Hash(pwd).toString();
            temp.setTpwd(md.toString());

            temp.setRecordid(recordId);
            temp.setCheccode(0);
            infos.add(temp);
        }
        //插入临时表
        if(!infos.isEmpty()) {
            checkTempMapper.insertBatch(infos);
        }
    }


}
