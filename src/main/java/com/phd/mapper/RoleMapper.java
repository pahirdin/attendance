package com.phd.mapper;

import com.phd.entity.Role;
import com.phd.entity.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    List<Role> selectAllByRolname(String ano);

    Boolean isGotRole(@Param("ano") String ano,@Param("rolename") String rolename);
}