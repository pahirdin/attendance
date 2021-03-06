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

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private LeaveMapper leaveMapper;
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
    public PageInfo<Leave> queryStuLeaves(Integer page, Integer limit, String aid, Integer lstatus,Integer cid,String name) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        if (StringUtils.isNotBlank(name)) {
            name = "%" + name + "%";
        }
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<Leave> list = this.leaveMapper.queryStuLeaves(lstatus,cid,name);
        for (Leave leave : list) {
            leave.setSname(this.studentInfoMapper.getSnameBySid(leave.getSid()));
            leave.setLtypeName(getLtypeNameByTypeId(leave.getLtype()));
            leave.setLstatusName(getLstatusNameByLstatus(leave.getLstatus()));
            leave.setAname(this.adminInfoMapper.getAnameByAid(leave.getAid()));
        }
        return new PageInfo<Leave>(list);
    }

    @Override
    public int updateLeave(Integer lid, Integer lstatus) {
        return this.leaveMapper.updateLeave(lid,lstatus);
    }

    @Override
    public List<Classes> queryClassesByInsAid(String aid) {
        return this.classesMapper.queryClassesByInsAid(aid);
    }

    @Override
    public PageInfo<Leave> queryStuLeavesIns(Integer page, Integer limit, String aid, Integer lstatus, Integer cid, String name) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        if (StringUtils.isNotBlank(name)) {
            name = "%" + name + "%";
        }
        //在帮助类中传入分页参数
        PageHelper.startPage(page, limit);
        List<Classes> classes = queryClassesByInsAid(aid);
        List<Integer> lists = classes.stream().map(Classes::getCid).collect(Collectors.toList());
//        String cids = String.join(",", lists.stream().map(String::valueOf).collect(Collectors.toList()));
        String cids = null;
        if (lists.isEmpty()) {
            cids = "'000'";
        }else {
            cids = "'"+StringUtils.join(lists,"','")+"'";
        }
        List<Leave> list = this.leaveMapper.queryStuLeavesIns(lstatus,cid,name,cids);
        for (Leave leave : list) {
            leave.setSname(this.studentInfoMapper.getSnameBySid(leave.getSid()));
            leave.setLtypeName(getLtypeNameByTypeId(leave.getLtype()));
            leave.setLstatusName(getLstatusNameByLstatus(leave.getLstatus()));
            leave.setAname(this.adminInfoMapper.getAnameByAid(leave.getAid()));
        }
        return new PageInfo<Leave>(list);
    }

    @Override
    public int setInformation(Integer awarnumm, String aemail, String aid) {
        return this.adminInfoMapper.setInformation(awarnumm,aemail,aid);
    }

    private String getLstatusNameByLstatus(String lstatus) {
        HashMap<String, String> map = new HashMap<>();
        map.put("0", "待审批");
        map.put("1","批准");
        map.put("2","拒绝");
        return map.get(lstatus);
    }

    private String getLtypeNameByTypeId(String ltype) {
        HashMap<String, String> map = new HashMap<>();
        map.put("0", "事假");
        map.put("1","病假");
        map.put("2","其它");
        return map.get(ltype);
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
