package com.phd.mapper;

import com.phd.entity.StudentInfo;
import com.phd.entity.StudentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentInfoMapper {
    long countByExample(StudentInfoExample example);

    int deleteByExample(StudentInfoExample example);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    List<StudentInfo> selectByExample(StudentInfoExample example);

    int updateByExampleSelective(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByExample(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    List<StudentInfo> queryStudenInfoByParam(@Param("sno") String sno,@Param("college") Integer college,@Param("major") Integer major);
}