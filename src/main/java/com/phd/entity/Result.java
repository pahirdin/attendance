package com.phd.entity;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.apache.xerces.xs.datatypes.ObjectList;

import java.util.List;

/**
 * @author pahaied
 * @date 2019/12/13 16:12
 */
@Data
public class Result<T> {
    private List<T> data;
    private long code;
    private long count;
    private String msg;

    public Result(){}

    public Result(PageInfo<T> info) {
        this.data = info.getList();
        this.code = 0;
        this.count = info.getTotal();
        this.msg = "";
    }
}
