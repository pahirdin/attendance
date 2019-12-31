package com.phd.service.impl;

import com.phd.entity.AdminInfo;
import com.phd.entity.ExcelData;
import com.phd.mapper.AdminInfoMapper;
import com.phd.service.IImportService;
import com.phd.utils.CommonUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
    @Override
    public Map<String,Object> getBankListByExcel(InputStream inputStream, String originalFilename, String recordId) throws Exception  {
        Map<String,Object> map = new HashMap<>();
        //获取文件内容
        List<List<Object>> fileList = CommonUtil.getFileList(inputStream, originalFilename);
        ArrayList<AdminInfo> infos = new ArrayList<>();
        //转实体集合
        for(List<Object> list : fileList) {
            AdminInfo adminInfo = new AdminInfo();
            //这里缺少校验
            adminInfo.setAname(String.valueOf(list.get(0)));
            adminInfo.setAtel(String.valueOf(list.get(1)));
            adminInfo.setAno(String.valueOf(list.get(2)));
            adminInfo.setApwd(String.valueOf(list.get(3)));
            infos.add(adminInfo);
        }
        map.put("tol",infos.size());
        map.put("erro","");
        map.put("recordid",recordId);
        return  map;
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
