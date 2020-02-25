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
        titles.add("工号");
        titles.add("姓名");
        titles.add("手机号");
        titles.add("密码");
        titles.add("所属学院");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList<>();
        List<Object> row1 = new ArrayList<>();
        row1.add("zhangsan123");
        row1.add("张三");
        row1.add("15675120314");
        row1.add("123456");
        row1.add("计算机与信息科学学院");
        rows.add(row1);

        List<Object> row2 = new ArrayList<>();
        row2.add("lisi123");
        row2.add("李四");
        row2.add("15675120314");
        row2.add("123456");
        row2.add("计算机与信息科学学院");
        rows.add(row2);

        List<Object> row3 = new ArrayList<>();
        row3.add("pahaied");
        row3.add("帕海尔丁·牙生");
        row3.add("15675120314");
        row3.add("123456");
        row3.add("计算机与信息科学学院");
        rows.add(row3);

        data.setRows(rows);
        return data;
    }

    @Override
    public ExcelData getStudentTmpExcelData() {
        ExcelData data = new ExcelData();
        data.setName("studentTmp");
        List<String> titles = new ArrayList<>();
        titles.add("学号");
        titles.add("姓名");
        titles.add("学院");
        titles.add("专业");
        titles.add("班级");
        titles.add("手机号");
        titles.add("宿舍");
        titles.add("家长手机号");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList<>();
        List<Object> row1 = new ArrayList<>();
        row1.add("16020440218");
        row1.add("张三");
        row1.add("计算机与信息科学学院");
        row1.add("软件工程");
        row1.add("1601班");
        row1.add("15675120314");
        row1.add("B6-404");
        row1.add("13579278004");
        rows.add(row1);

        List<Object> row2 = new ArrayList<>();
        row2.add("16020440219");
        row2.add("李四");
        row2.add("计算机与信息科学学院");
        row2.add("软件工程");
        row2.add("1602班");
        row2.add("15675120314");
        row2.add("B6-404");
        row2.add("13579278004");
        rows.add(row2);

        List<Object> row3 = new ArrayList<>();
        row3.add("16020440220");
        row3.add("帕海尔丁·牙生");
        row3.add("计算机与信息科学学院");
        row3.add("软件工程");
        row3.add("1603班");
        row3.add("15675120314");
        row3.add("B6-404");
        row3.add("13579278004");
        rows.add(row3);

        data.setRows(rows);
        return data;
    }

    @Override
    public ExcelData getClassTmpExcelData() {
        ExcelData data = new ExcelData();
        data.setName("classTmp");
        List<String> titles = new ArrayList<>();
        titles.add("学业");
        titles.add("专业");
        titles.add("班级");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList<>();
        List<Object> row1 = new ArrayList<>();
        row1.add("计算机与信息科学");
        row1.add("软件工程");
        row1.add("2005班");
        rows.add(row1);

        List<Object> row2 = new ArrayList<>();
        row2.add("安全与环境工程学院");
        row2.add("安全工程");
        row2.add("2002班");
        rows.add(row2);

        List<Object> row3 = new ArrayList<>();
        row3.add("经济与管理学院");
        row3.add("会计学");
        row3.add("2001班");

        rows.add(row3);

        data.setRows(rows);
        return data;
    }
}
