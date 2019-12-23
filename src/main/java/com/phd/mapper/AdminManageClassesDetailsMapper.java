package com.phd.mapper;

import com.phd.entity.AdminManageClassesDetails;
import com.phd.entity.AdminManageClassesDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminManageClassesDetailsMapper {
    long countByExample(AdminManageClassesDetailsExample example);

    int deleteByExample(AdminManageClassesDetailsExample example);

    int insert(AdminManageClassesDetails record);

    int insertSelective(AdminManageClassesDetails record);

    List<AdminManageClassesDetails> selectByExample(AdminManageClassesDetailsExample example);

    int updateByExampleSelective(@Param("record") AdminManageClassesDetails record, @Param("example") AdminManageClassesDetailsExample example);

    int updateByExample(@Param("record") AdminManageClassesDetails record, @Param("example") AdminManageClassesDetailsExample example);
}