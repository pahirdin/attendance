package com.phd.service;

import com.phd.entity.ExcelData;

/**
 * @author pahaied
 * @date 2019/12/30 15:58
 */
public interface IDownloadTemplateService {
    /**
     * 管理员新增模板
     * @return
     */
    ExcelData getAdminTmpExcelData();
}
