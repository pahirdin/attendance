package com.phd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.phd.entity.*;
import com.phd.mapper.ClassesMapper;
import com.phd.mapper.CourseMapper;
import com.phd.mapper.SchoolAttendanceDetailsMapper;
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
    @Autowired
    private SchoolAttendanceDetailsMapper schoolAttendanceDetailsMapper;
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

    @Override
    public PageInfo<StudentInfo> checkAttendanceStateBysaid(Long said, Integer state,Integer page, Integer limit) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<StudentInfo> list = this.schoolAttendanceDetailsMapper.checkAttendanceStateBysaid(said, state);
        return new PageInfo<StudentInfo>(list);
    }

    @Override
    public int deleteSchoolattendanceInfo(Long said) {
        SchoolAttendanceDetailsExample schoolAttendanceDetailsExample = new SchoolAttendanceDetailsExample();
        schoolAttendanceDetailsExample.createCriteria().andSaidEqualTo(said);
        this.schoolAttendanceDetailsMapper.deleteByExample(schoolAttendanceDetailsExample);
        SchoolAttendanceExample schoolAttendanceExample = new SchoolAttendanceExample();
        schoolAttendanceExample.createCriteria().andSaidEqualTo(said);
        return this.schoolAttendanceMapper.deleteByExample(schoolAttendanceExample);
    }
}
