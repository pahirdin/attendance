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
     * @param recordId
     */
    int checkAdminNoRepeatByRecordId(String recordId);
}