package com.phd.service;

import com.phd.entity.ExcelData;

/**
 * @author pahaied
 * @date 2019/12/30 15:58
 */
public interface IDownloadTemplateService {
    /**
     * 管理员新增模板
     * @return ExcelData
     */
    ExcelData getAdminTmpExcelData();

    /**
     * 学生信息新增模板
     * @return ExcelData
     */
    ExcelData getStudentTmpExcelData();

    /**
     * 班级信息新增模板
     * @return ExcelData
     */
    ExcelData getClassTmpExcelData();
}
