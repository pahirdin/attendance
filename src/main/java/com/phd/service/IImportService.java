package com.phd.service;

import com.phd.entity.ExcelData;

import java.io.InputStream;
import java.util.Map;

/**
 * @author pahaied
 * @date 2019/12/30 9:47
 */
public interface IImportService {
    Map<String,Object> getBankListByExcel(InputStream inputStream, String originalFilename, String recordId) throws Exception;

    ExcelData getExcelData(String recordid);
}
