package com.phd.service;

import com.phd.entity.AdminInfo;
import com.phd.entity.ClassCode;

import java.util.List;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-03-22
 */
public interface IInstructorService {
    List<ClassCode> getClassInstructorNonSelect(AdminInfo admin);
}
