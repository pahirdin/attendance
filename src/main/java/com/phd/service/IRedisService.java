package com.phd.service;

import com.phd.entity.Major;

/**
 * 缓存服务类
 * @author pahaied
 * @date 2020/1/17 14:34
 */
public interface IRedisService {
    /**
     * 根据专业名和学院id查询专业id
     * @param majorName 专业名
     * @param coid 学业id
     * @return 返回专业ID
     */
    Integer getMajorByName(String majorName, Integer coid);

    /**
     * 根据班级名和专业id查询班级ID
     * @param classesName 班级名
     * @param majorId 专业ID
     * @return 班级ID
     */
    Integer getClassesIdByName(String classesName, Integer majorId);
}
