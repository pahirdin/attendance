package com.phd.utils;

import com.github.pagehelper.PageInfo;
import com.phd.entity.Classes;

import java.util.List;

/**
 * @author pahaied
 * @date 2019/12/13 17:33
 */
public class MyPageInfo<T> extends PageInfo<T> {
    private long code;
    private long count;
    private String msg;
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;

    //由于startRow和endRow不常用，这里说个具体的用法
    //可以在页面中"显示startRow到endRow 共size条数据"

    //当前页面第一个元素在数据库中的行号
    private int startRow;
    //当前页面最后一个元素在数据库中的行号
    private int endRow;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> data;

    //前一页
    private int prePage;
    //下一页
    private int nextPage;

    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;
    //是否有前一页
    private boolean hasPreviousPage = false;
    //是否有下一页
    private boolean hasNextPage = false;
    //导航页码数
    private int navigatePages;
    //所有导航页号
    private int[] navigatepageNums;
    //导航条上的第一页
    private int navigateFirstPage;
    //导航条上的最后一页
    private int navigateLastPage;


    public MyPageInfo(PageInfo<T> info) {
        this.pageNum = info.getPageNum();
        this.pageSize = info.getPageSize();
        this.size = info.getSize();
        this.startRow = info.getStartRow();
        this.endRow = info.getEndRow();
        this.total = info.getTotal();
        this.pages = info.getPages();
        this.prePage = info.getPrePage();
        this.nextPage = info.getNextPage();
        this.isFirstPage = info.isIsFirstPage();
        this.isLastPage = info.isIsLastPage();
        this.hasPreviousPage = info.isHasPreviousPage();
        this.hasNextPage = info.isHasNextPage();
        this.navigatePages = info.getNavigatePages();
        this.navigatepageNums = info.getNavigatepageNums();
        this.navigateFirstPage = info.getNavigateFirstPage();
        this.navigateLastPage = info.getNavigateLastPage();
        this.data = info.getList();
        this.count = info.getTotal();
        this.msg = "";
        this.code = 0;
    }
}
