package com.phd.utils;

import com.phd.entity.AdminInfo;
import com.phd.entity.ExcelData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author pahaied
 * @date 2019/12/31 15:42
 */
public class CommonUtil {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        //015ef458-d274-4ac2-a32d-19cc9c079631
        String str = uuid.toString();
        //015ef458d2744ac2a32d19cc9c079631
        return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
    }

    public static List<List<Object>> getFileList(InputStream inputStream, String originalFilename) throws Exception {
        List list = new ArrayList<>();
        //创建Excel工作薄
        Workbook work = getWorkbook(inputStream, originalFilename);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<Object> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }
    /**
     * 判断文件格式
     *
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    private static Workbook getWorkbook(InputStream inStr, String fileName){
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        try {
            if (".xls".equals(fileType)) {
                workbook = new XSSFWorkbook(inStr);
            } else if (".xlsx".equals(fileType)) {
                workbook = new XSSFWorkbook(inStr);
            } else {
                throw new Exception("请上传excel文件！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }



}
