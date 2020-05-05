package com.phd.service.impl;

import com.phd.entity.AdminInfo;
import com.phd.entity.ClassCode;
import com.phd.mapper.AdminManageClassesDetailsMapper;
import com.phd.service.IInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-03-22
 */
@Service
public class InstructorServiceImpl implements IInstructorService {
    @Autowired
    private AdminManageClassesDetailsMapper adminManageClassesDetailsMapper;
    @Override
    public List<ClassCode> getClassInstructorNonSelect(AdminInfo admin) {
        String aid = admin.getAid();
        Integer coid = admin.getCoid();

        return this.adminManageClassesDetailsMapper.getClassInstructorNonSelect(aid,coid);
    }
}
