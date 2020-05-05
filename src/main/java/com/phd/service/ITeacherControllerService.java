package com.phd.service;

import com.github.pagehelper.PageInfo;
import com.phd.entity.Classes;
import com.phd.entity.Course;
import com.phd.entity.SchoolAttendance;

import java.util.List;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-05-05
 */
public interface ITeacherControllerService {
    PageInfo<SchoolAttendance> queryClassAttendanceTeacher(Integer page, Integer limit, Integer couid, Integer cid, String aid);

    List<Course> queryCourseByAid(String aid);

    List<Classes> getClassesByCouid(Integer couid);
}
