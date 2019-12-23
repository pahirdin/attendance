package com.phd.mapper;

import com.phd.entity.AdminManageClasses;
import com.phd.entity.AdminManageClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminManageClassesMapper {
    long countByExample(AdminManageClassesExample example);

    int deleteByExample(AdminManageClassesExample example);

    int insert(AdminManageClasses record);

    int insertSelective(AdminManageClasses record);

    List<AdminManageClasses> selectByExample(AdminManageClassesExample example);

    int updateByExampleSelective(@Param("record") AdminManageClasses record, @Param("example") AdminManageClassesExample example);

    int updateByExample(@Param("record") AdminManageClasses record, @Param("example") AdminManageClassesExample example);
}