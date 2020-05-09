package com.phd.mapper;

import com.phd.entity.AdminInfo;
import com.phd.entity.AdminInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminInfoMapper {
    long countByExample(AdminInfoExample example);

    int deleteByExample(AdminInfoExample example);

    int insert(AdminInfo record);

    int insertSelective(AdminInfo record);

    List<AdminInfo> selectByExample(AdminInfoExample example);

    int updateByExampleSelective(@Param("record") AdminInfo record, @Param("example") AdminInfoExample example);

    int updateByExample(@Param("record") AdminInfo record, @Param("example") AdminInfoExample example);

    /**
     * 根据
     * @param adminAname
     * @return
     */
    AdminInfo selectByAdminByAid(String adminAname);

    List<AdminInfo> queryAdminInfoByParam(Integer college, String role,String name);

    String getAnameByAid(@Param("aid") String aid);

    String getAnameByCouid(@Param("couid") Integer couid);

    String getAtelByCouid(@Param("couid")Integer couid);

    int setInformation(@Param("awarnumm") Integer awarnumm,@Param("aemail") String aemail,@Param("aid") String aid);
}