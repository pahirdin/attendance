package com.phd.mapper;

import com.phd.entity.College;
import com.phd.entity.CollegeExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CollegeMapper {
    long countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    HashMap<Integer, String> queryAllCollege();
}