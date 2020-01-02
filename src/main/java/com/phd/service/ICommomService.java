package com.phd.service;

import com.phd.entity.CheckTemp;
import com.phd.entity.College;
import com.phd.entity.Major;

import java.util.List;

/**
 * @author pahaied
 * @date 2019/12/19 17:03
 */
public interface ICommomService {
    /**
     * 获取所有学业
     * @return
     */
    List<College> findAllCollege();

    /**
     * 根据学院获取专业
     * @return
     */
    List<Major> getMajorByCoid(Integer coid);

    /**
     * 根据流水号查询临时表
     * @param recordId
     * @return
     */
    List<CheckTemp> queryTempListByRecordId(String recordId);

    /**
     * 保存临时表数据
     * @param tempList
     */
    void saveTempTable(List<CheckTemp> tempList);
}
