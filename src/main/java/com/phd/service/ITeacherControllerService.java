package com.phd.service;

import com.github.pagehelper.PageInfo;
import com.phd.entity.*;

import java.util.List;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-05-05
 */
public interface ITeacherControllerService {
    PageInfo<SchoolAttendance> queryClassAttendanceTeacher(Integer page, Integer limit, Integer couid, Integer cid, String aid);

    List<Course> queryCourseByAid(String aid);

    List<Classes> getClassesByCouid(Integer couid);

    PageInfo<StudentInfo> checkAttendanceStateBysaid(Long said, Integer state,Integer page, Integer limit);

    int deleteSchoolattendanceInfo(Long said);

    PageInfo<StudentInfo> queryStuAttendanceTeacher(Integer page, Integer limit, Integer couid, Integer cid, String aid, String start, String end, String name);

    PageInfo<SchoolAttendance> checkLeavDil(Integer sid, String start, String end, Integer page, Integer limit);

    List<Course> queryCourseByCid(Integer cid);

    Integer getCidByHeadmasterId(String aid);
}
