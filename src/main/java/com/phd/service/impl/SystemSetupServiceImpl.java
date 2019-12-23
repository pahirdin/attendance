package com.phd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.phd.entity.Classes;
import com.phd.mapper.ClassesMapper;
import com.phd.service.ISystemSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pahaied
 * @date 2019/12/13 11:16
 */
@Service
public class SystemSetupServiceImpl implements ISystemSetupService {
    @Autowired
    private ClassesMapper classesMapper;
    @Override
    public PageInfo<Classes> findAllClasses(Integer page, Integer limit, Integer aid) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<Classes> list = classesMapper.selectAllClasses();
        PageInfo<Classes> pagelist = new PageInfo<Classes>(list);
//        long total = pagelist.getTotal();
//        List<Classes> list1 = pagelist.getList();
        return pagelist;
    }
}
