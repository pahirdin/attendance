package com.phd.service;

import com.phd.entity.AdminInfo;
import com.phd.entity.CheckTemp;
import com.phd.entity.College;
import com.phd.entity.Major;

import java.util.HashMap;
import java.util.List;

/**
 * @author pahaied
 * @date 2019/12/19 17:03
 */
public interface ICommomService {
    /**
     * 获取所有学院
     * @return List<College>
     */
    List<College> findAllCollege();
    /**
     * 获取所有学院
     * @return Map<String, String>
     */
    HashMap<Integer, String> queryAllCollege();


    /**
     * 根据学院获取专业
     * @param coid 学院id
     * @return List<Major>
     */
    List<Major> getMajorByCoid(Integer coid);

    /**
     * 根据流水号查询临时表
     * @param recordId 流水号
     * @param checkcode 成功标识
     * @return List<CheckTemp>
     */
    List<CheckTemp> queryTempListByRecordId(String recordId, Integer checkcode);

    /**
     * 保存临时表数据
     * @param tempList 管理员临时信息
     */
    void saveTempTable(List<CheckTemp> tempList);

    /**
     * 根据工号查询管理员信息
     * @param ano
     * @return
     */
    AdminInfo getAdminInfoByAno(String ano);
}
