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
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
        List<CheckTemp> tempList = commomServiceImpl.queryTempListByRecordId(recordId);
        //成功的数据
        List<CheckTemp> succlist = new ArrayList<>();
        //校验并保存临时表
        checkInfos(tempList, succlist);

        map.put("tol",infos.size());
        map.put("erro",infos.size()-succlist.size());
        map.put("recordid",recordId);
        map.put("suc",succlist.size());
        return  map;
    }

    public void checkInfos(List<CheckTemp> tempList, List<CheckTemp> succlist) {
        HashMap<String, String> nos = new HashMap<>();
        for(CheckTemp temp : tempList) {
            boolean tag = true;
            if(tag) {
                if(nos.containsKey(temp.getTno())) {
                    tag = false;
                    temp.setCheckinfo("该工号重复");
                    temp.setCheccode(2);
                }
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
                nos.put(temp.getTno(),temp.getTno());
                temp.setCheccode(1);
                succlist.add(temp);
            }
        }
        commomServiceImpl.saveTempTable(tempList);
    }


    private void insertTmpByAdminFileList(String recordId, List<List<Object>> fileList, ArrayList<CheckTemp> infos) {
        //转实体集合
        for(List<Object> list : fileList) {
            CheckTemp temp = new CheckTemp();
            if(StringUtils.isBlank(String.valueOf(list.get(0)))) {
                break;
            }
            temp.setTno(String.valueOf(list.get(0)));
            temp.setTname(String.valueOf(list.get(1)));
            temp.setTtel(String.valueOf(list.get(2)));
            String pwd = "".equals(String.valueOf(list.get(3))) ? "123456" : String.valueOf(list.get(3));
            Object md = new SimpleHash("MD5",pwd,null,1024);
            temp.setTpwd(md.toString());
            temp.setConame(String.valueOf(list.get(4)));
            temp.setRecordid(recordId);
            temp.setCheccode(0);
            infos.add(temp);
        }
        //插入临时表
        checkTempMapper.insertBatch(infos);
    }

    @Override
    public ExcelData getExcelData() {
        int rowIndex = 0;
        List<AdminInfo> list = adminInfoMapper.selectByExample(null);
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("ID");
        titles.add("userName");
        titles.add("password");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        for(int i = 0, length = list.size();i<length;i++){
            AdminInfo userInfo = list.get(i);
            List<Object> row = new ArrayList();
            row.add(userInfo.getAid());
            row.add(userInfo.getAname());
            row.add(userInfo.getAno());
            rows.add(row);
        }
        data.setRows(rows);
        return data;
    }



}
