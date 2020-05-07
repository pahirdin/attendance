package com.phd.mapper;

import com.phd.entity.SchoolAttendanceDetails;
import com.phd.entity.SchoolAttendanceDetailsExample;
import java.util.List;

import com.phd.entity.StudentInfo;
import org.apache.ibatis.annotations.Param;

public interface SchoolAttendanceDetailsMapper {
    long countByExample(SchoolAttendanceDetailsExample example);

    int deleteByExample(SchoolAttendanceDetailsExample example);

    int insert(SchoolAttendanceDetails record);

    int insertSelective(SchoolAttendanceDetails record);

    List<SchoolAttendanceDetails> selectByExample(SchoolAttendanceDetailsExample example);

    int updateByExampleSelective(@Param("record") SchoolAttendanceDetails record, @Param("example") SchoolAttendanceDetailsExample example);

    int updateByExample(@Param("record") SchoolAttendanceDetails record, @Param("example") SchoolAttendanceDetailsExample example);

    List<StudentInfo> checkAttendanceStateBysaid(@Param("said") Long said, @Param("state") Integer state);
}