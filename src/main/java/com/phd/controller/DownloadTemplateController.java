package com.phd.controller;

import com.phd.entity.ExcelData;
import com.phd.service.IDownloadTemplateService;
import com.phd.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 下载模板控制器
 * @author pahaied
 * @date 2019/12/30 15:54
 */
@Controller
public class DownloadTemplateController {

    @Autowired
    private IDownloadTemplateService downloadTemplateServiceImpl;
    /**
     * 管理员批量新增模板
     * @param response
     */
    @RequestMapping(value = "/downAddAdminTmp")
    @ResponseBody
    public void downAddAdminTmp(HttpServletResponse response) {
        ExcelData data = downloadTemplateServiceImpl.getAdminTmpExcelData();
        try{
            ExcelUtils.exportExcel(response,"管理员新增模板",data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 学生新增模板下载
     * @param response response
     */
    @RequestMapping("/downAddStudentTmp")
    @ResponseBody
    public void downAddStudentTmp(HttpServletResponse response) {
        ExcelData data = downloadTemplateServiceImpl.getStudentTmpExcelData();
        try{
            ExcelUtils.exportExcel(response,"学生信息新增模板",data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
