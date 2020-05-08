package com.phd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.phd.entity.*;
import com.phd.mapper.*;
import com.phd.service.ITeacherControllerService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
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
    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private AdminInfoMapper adminInfoMapper;
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
    public PageInfo<SchoolAttendance> queryClassAttendanceCollegeAdmin(Integer page, Integer limit, Integer couid, Integer cid, String aid) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<SchoolAttendance> list = this.schoolAttendanceMapper.queryClassAttendanceTeacher(couid,cid);
        for (SchoolAttendance schoolAttendance : list) {
            schoolAttendance.setCouname(courseMapper.getCounameByCouid(schoolAttendance.getCouid()));
            schoolAttendance.setCname(classesMapper.getCnameByCid(schoolAttendance.getCid()));
            schoolAttendance.setMname(majorMapper.getMnameByCid(schoolAttendance.getCid()));
            schoolAttendance.setAname(adminInfoMapper.getAnameByCouid(schoolAttendance.getCouid()));
            schoolAttendance.setAtel(adminInfoMapper.getAtelByCouid(schoolAttendance.getCouid()));
        }
        return new PageInfo<SchoolAttendance>(list);
    }

    @Override
    public PageInfo<SchoolAttendance> queryStatisticsAttendanceCollegeAdmin(Integer page, Integer limit, Integer couid, Integer cid, String name, AdminInfo admin) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        if (StringUtils.isNotBlank(name)) {
            name = "%"+name+"%";
        }
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<SchoolAttendance> list = this.schoolAttendanceMapper.queryStatisticsAttendanceCollegeAdmin(couid,cid,name,admin.getCoid());
        for (SchoolAttendance schoolAttendance : list) {
            schoolAttendance.setAname(this.adminInfoMapper.getAnameByCouid(schoolAttendance.getCouid()));
            schoolAttendance.setAtel(this.adminInfoMapper.getAtelByCouid(schoolAttendance.getCouid()));
            schoolAttendance.setCouname(this.courseMapper.getCounameByCouid(schoolAttendance.getCouid()));
            schoolAttendance.setCname(this.classesMapper.getCnameByCid(schoolAttendance.getCid()));

        }
        return new PageInfo<SchoolAttendance>(list);
    }

    @Override
    public PageInfo<SchoolAttendance> queryStatisticsAttendanceSchoolAdmin(Integer page, Integer limit, String aid, String start, String end) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<SchoolAttendance> list = this.schoolAttendanceMapper.queryStatisticsAttendanceSchoolAdmin(start,end);
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

    @Override
    public PageInfo<StudentInfo> queryStuAttendanceTeacher(Integer page, Integer limit, Integer couid, Integer cid, String aid, String start, String end, String name) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        if (StringUtils.isNotBlank(name)) {
            name = "%" + name + "%";
        }
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<StudentInfo> list = this.schoolAttendanceDetailsMapper.queryStuAttendanceTeacher(couid, cid,start,end,name,aid);
        for (StudentInfo studentInfo : list) {
            studentInfo.setCname(this.classesMapper.getCnameByCid(studentInfo.getCid()));
        }
        return new PageInfo<StudentInfo>(list);
    }

    @Override
    public PageInfo<SchoolAttendance> checkLeavDil(Integer sid, String start, String end, Integer page, Integer limit) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<SchoolAttendance> list = this.schoolAttendanceMapper.checkLeavDil(sid,start,end);
        String sname = this.studentInfoMapper.getSnameBySid(sid);
        for (SchoolAttendance schoolAttendance : list) {
            schoolAttendance.setCouname(this.courseMapper.getCounameByCouid(schoolAttendance.getCouid()));
            schoolAttendance.setCname(this.classesMapper.getCnameByCid(schoolAttendance.getCid()));
            schoolAttendance.setSname(sname);
        }
        return new PageInfo<SchoolAttendance>(list);
    }

    @Override
    public List<Course> queryCourseByCid(Integer cid) {
        return this.courseMapper.queryCourseByCid(cid);
    }

    @Override
    public Integer getCidByHeadmasterId(String aid) {
        List<Classes> classecByMasterId = this.classesMapper.getClassecByMasterId(aid);
        if (null == classecByMasterId || classecByMasterId.size() == 0) {
            return null;
        }
        return classecByMasterId.get(0).getCid();
    }

    @Override
    public List<Course> queryCourseByInsAid(String aid) {
        return this.courseMapper.queryCourseByInsAid(aid);
    }

    @Override
    public List<Course> queryCourseByStuCoid(Integer coid) {
        return this.courseMapper.queryCourseByStuCoid(coid);
    }

}
