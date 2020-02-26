package com.phd.mapper;

import com.phd.entity.CheckTemp;
import com.phd.entity.CheckTempExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckTempMapper {
    long countByExample(CheckTempExample example);

    int deleteByExample(CheckTempExample example);

    int insert(CheckTemp record);

    int insertSelective(CheckTemp record);

    List<CheckTemp> selectByExample(CheckTempExample example);

    int updateByExampleSelective(@Param("record") CheckTemp record, @Param("example") CheckTempExample example);

    int updateByExample(@Param("record") CheckTemp record, @Param("example") CheckTempExample example);

    void insertBatch(ArrayList<CheckTemp> infos);

    void updateByBatch(List<CheckTemp> tempList);

    int moveTempToAdminInfoTable(String recordId);

    /**
     * 根据流水号校验掉重复的工号
     * @param recordId 流水号
     * @return 总数
     */
    int checkAdminNoRepeatByRecordId(String recordId);

    int checkStudentNoRepeatByRecordId(String recordId);

    int moveTempToStudentInfoTable(String recordId);

    /**
     * 新增管理员后赋初始权
     * @param recordId 流水号
     * @return 总数
     */
    int addRolesByTemp(String recordId);

    /**
     * 根据流水号临时表搬到（新增）班级表
     * @param recordId 流水号
     * @return 总数
     */
    int moveTempToClassTable(String recordId);
}