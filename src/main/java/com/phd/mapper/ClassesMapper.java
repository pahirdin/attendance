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

    List<Classes> selectAllClasses(@Param("college") Integer college,@Param("major") Integer major,@Param("className") String className);

    int setClassesIns(@Param("cid") Integer cid,@Param("aid") String aid);

    List<Classes> getClassecByMasterId(@Param("aid") String aid);

    int setClassesMaster(@Param("cid") Integer cid,@Param("aid") String aid);

    String getCnameByCid(@Param("cid")Integer cid);

    List<Classes> getClassesByCouid(@Param("couid") Integer couid);

    List<Classes> queryClassesByInsAid(@Param("aid") String aid);
}