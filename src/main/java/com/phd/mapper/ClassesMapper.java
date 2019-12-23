package com.phd.mapper;

import com.phd.entity.Classes;
import com.phd.entity.ClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassesMapper {
    long countByExample(ClassesExample example);

    int deleteByExample(ClassesExample example);

    int insert(Classes record);

    int insertSelective(Classes record);

    List<Classes> selectByExample(ClassesExample example);

    int updateByExampleSelective(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByExample(@Param("record") Classes record, @Param("example") ClassesExample example);

    List<Classes> selectAllClasses();
}