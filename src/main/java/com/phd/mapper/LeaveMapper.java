package com.phd.mapper;

import com.phd.entity.Leave;
import com.phd.entity.LeaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeaveMapper {
    long countByExample(LeaveExample example);

    int deleteByExample(LeaveExample example);

    int insert(Leave record);

    int insertSelective(Leave record);

    List<Leave> selectByExample(LeaveExample example);

    int updateByExampleSelective(@Param("record") Leave record, @Param("example") LeaveExample example);

    int updateByExample(@Param("record") Leave record, @Param("example") LeaveExample example);

    List<Leave> queryStuLeaves(@Param("lstatus") Integer lstatus,@Param("cid") Integer cid,@Param("name") String name);

    int updateLeave(@Param("lid") Integer lid,@Param("lstatus") Integer lstatus);

    List<Leave> queryStuLeavesIns(@Param("lstatus") Integer lstatus,@Param("cid") Integer cid,
                                  @Param("name") String name,@Param("cids") String cids);
}