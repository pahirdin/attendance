package com.phd.service;

import com.github.pagehelper.PageInfo;
import com.phd.entity.Classes;

/**
 * @author pahaied
 * @date 2019/12/13 11:16
 */
public interface ISystemSetupService {
    PageInfo<Classes> findAllClasses(Integer page, Integer limit, Integer aid);
}
