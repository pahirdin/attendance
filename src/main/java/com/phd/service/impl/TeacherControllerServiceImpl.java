package com.phd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.phd.entity.*;
import com.phd.mapper.ClassesMapper;
import com.phd.mapper.CourseMapper;
import com.phd.mapper.SchoolAttendanceMapper;
import com.phd.service.ITeacherControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-05-05
 */
@Service
public class TeacherControllerServiceImpl implements ITeacherControllerService {
    @Autowired
    private SchoolAttendanceMapper schoolAttendanceMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ClassesMapper classesMapper;
    @Override
    public PageInfo<SchoolAttendance> queryClassAttendanceTeacher(Integer page, Integer limit, Integer couid, Integer cid, String aid) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<SchoolAttendance> list = this.schoolAttendanceMapper.queryClassAttendanceTeacher(couid,cid);
        for (SchoolAttendance schoolAttendance : list) {
            schoolAttendance.setCouname(courseMapper.getCounameByCouid(schoolAttendance.getCouid()));
            schoolAttendance.setCname(classesMapper.getCnameByCid(schoolAttendance.getCid()));
        }
        return new PageInfo<SchoolAttendance>(list);
    }

    @Override
    public List<Course> queryCourseByAid(String aid) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andAidEqualTo(aid);
        return this.courseMapper.selectByExample(courseExample);
    }

    @Override
    public List<Classes> getClassesByCouid(Integer couid) {
        return this.classesMapper.getClassesByCouid(couid);
    }
}
