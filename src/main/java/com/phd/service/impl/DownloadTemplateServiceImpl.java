package com.phd.service.impl;

import com.phd.entity.ExcelData;
import com.phd.service.IDownloadTemplateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板下载
 * @author pahaied
 * @date 2019/12/30 15:58
 */
@Service
public class DownloadTemplateServiceImpl implements IDownloadTemplateService {
    /**
     * 管理员新增模板
     * @return Exceptions
     */
    @Override
    public ExcelData getAdminTmpExcelData() {
        ExcelData data = new ExcelData();
        data.setName("adminTmp");
        List<String> titles = new ArrayList<>();
        titles.add("姓名");
        titles.add("手机号");
        titles.add("工号");
        titles.add("密码");
        titles.add("所属学院");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList<>();
        List<Object> row1 = new ArrayList<>();
        row1.add("张三");
        row1.add("15675120314");
        row1.add("zhangsan123");
        row1.add("123456");
        row1.add("计算机与信息科学学院");
        rows.add(row1);

        List<Object> row2 = new ArrayList<>();
        row2.add("李四");
        row2.add("15675120314");
        row2.add("lisi123");
        row2.add("123456");
        row2.add("计算机与信息科学学院");
        rows.add(row2);

        List<Object> row3 = new ArrayList<>();
        row3.add("帕海尔丁·牙生");
        row3.add("15675120314");
        row3.add("pahaied");
        row3.add("123456");
        row3.add("计算机与信息科学学院");
        rows.add(row3);

        data.setRows(rows);
        return data;
    }
}
