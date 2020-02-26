package com.phd.service;

import com.phd.entity.ExcelData;

import java.io.InputStream;
import java.util.Map;

/**
 * @author pahaied
 * @date 2019/12/30 9:47
 */
public interface IImportService {
    /**
     * 新增管理员信息
     * @param inputStream 文件内容
     * @param originalFilename 文件名
     * @param recordId 流水号
     * @return map
     * @throws Exception 错误
     */
    Map<String,Object> getAdminListByExcel(InputStream inputStream, String originalFilename, String recordId) throws Exception;

    /**
     * 获取错误信息
     * @param recordid 流水号
     * @return excel内容
     */
    ExcelData getExcelData(String recordid);

    /**
     * 新增学生信息
     * @param inputStream 文件内容
     * @param originalFilename 文件名
     * @param recordId 流水号
     * @return map
     *  @throws Exception 错误
     */
    Map<String, Object> getStudentListByExcel(InputStream inputStream, String originalFilename, String recordId) throws Exception;

    /**
     * 批量新增班级信息
     * @param inputStream 文件内容
     * @param originalFilename 文件名
     * @param recordId 流水号
     * @return 结果map
     * @throws Exception 错误
     */
    Map<String, Object> getClassListByExcel(InputStream inputStream, String originalFilename, String recordId) throws Exception;
}
