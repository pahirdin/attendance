package com.phd.service.impl;

import com.phd.entity.AdminInfo;
import com.phd.entity.CheckTemp;
import com.phd.entity.CheckTempExample;
import com.phd.entity.ExcelData;
import com.phd.mapper.AdminInfoMapper;
import com.phd.mapper.CheckTempMapper;
import com.phd.service.ICommomService;
import com.phd.service.IImportService;
import com.phd.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
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
    @Override
    public Map<String,Object> getBankListByExcel(InputStream inputStream, String originalFilename, String recordId) throws Exception  {
        Map<String,Object> map = new HashMap<>();
        //获取文件内容
        List<List<Object>> fileList = CommonUtil.getFileList(inputStream, originalFilename);
        ArrayList<CheckTemp> infos = new ArrayList<>();
        //插入临时表
        insertTmpByAdminFileList(recordId, fileList, infos);
        //获取需要操作的数据
        List<CheckTemp> tempList = commomServiceImpl.queryTempListByRecordId(recordId,0);
        //校验并保存临时表
        checkInfos(tempList,recordId);
        //成功的数据
//        List<CheckTemp> succlist = commomServiceImpl.queryTempListByRecordId(recordId,1);

        //临时表数据搬到管理员表
        int suc = checkTempMapper.moveTempToAdminInfoTable(recordId);
        if(infos.size() == 0) {
            map.put("allerro","0");
        }
        map.put("tol",infos.size());
        map.put("erro",infos.size()-suc);
        map.put("recordid",recordId);
        map.put("suc",suc);
        return  map;
    }

    public void checkInfos(List<CheckTemp> tempList, String recordId) {
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



}
