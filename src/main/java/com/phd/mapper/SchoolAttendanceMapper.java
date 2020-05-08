package com.phd.mapper;

import com.phd.entity.SchoolAttendance;
import com.phd.entity.SchoolAttendanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolAttendanceMapper {
    long countByExample(SchoolAttendanceExample example);

    int deleteByExample(SchoolAttendanceExample example);

    int insert(SchoolAttendance record);

    int insertSelective(SchoolAttendance record);

    List<SchoolAttendance> selectByExample(SchoolAttendanceExample example);

    int updateByExampleSelective(@Param("record") SchoolAttendance record, @Param("example") SchoolAttendanceExample example);

    int updateByExample(@Param("record") SchoolAttendance record, @Param("example") SchoolAttendanceExample example);

    List<SchoolAttendance> queryClassAttendanceTeacher(Integer couid, Integer cid);

    List<SchoolAttendance> checkLeavDil(@Param("sid") Integer sid,@Param("start") String start,@Param("end") String end);

    List<SchoolAttendance> queryStatisticsAttendanceCollegeAdmin(@Param("couid") Integer couid,@Param("cid") Integer cid,
                                                                 @Param("name") String name,@Param("coid") Integer coid);

    List<SchoolAttendance> queryStatisticsAttendanceSchoolAdmin(@Param("start") String start,@Param("end") String end);
}