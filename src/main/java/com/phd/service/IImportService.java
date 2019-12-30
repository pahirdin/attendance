package com.phd.service;

import com.phd.entity.ExcelData;

import java.io.InputStream;
import java.util.List;

/**
 * @author pahaied
 * @date 2019/12/30 9:47
 */
public interface IImportService {
    List<List<Object>> getBankListByExcel(InputStream inputStream, String originalFilename) throws Exception;

    ExcelData getExcelData();
}
