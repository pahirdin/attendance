package com.phd.mapper;

import com.phd.entity.Course;
import com.phd.entity.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    String getCounameByCouid(@Param("couid") Integer couid);

    List<Course> queryCourseByCid(@Param("cid") Integer cid);

    List<Course> queryCourseByInsAid(@Param("aid") String aid);

    List<Course> queryCourseByStuCoid(@Param("coid") Integer coid);
}