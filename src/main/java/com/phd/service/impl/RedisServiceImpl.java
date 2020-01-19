package com.phd.service.impl;

import com.phd.entity.Classes;
import com.phd.entity.ClassesExample;
import com.phd.entity.Major;
import com.phd.entity.MajorExample;
import com.phd.mapper.ClassesMapper;
import com.phd.mapper.MajorMapper;
import com.phd.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pahaied
 * @date 2020/1/17 14:35
 */
@Service
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private ClassesMapper classesMapper;

    /**
     * 根据专业名和学院id查询专业id
     * 先从redis取 如果redis里没有查询数据库保存redis 再返回专业id
     * @param majorName 专业名
     * @param coid 学业id
     * @return
     */
    @Override
    public Integer getMajorByName(String majorName, Integer coid) {
        Object majorId = redisTemplate.boundHashOps("major").get(coid+"|"+majorName);
        if (null == majorId) {
            MajorExample majorExample = new MajorExample();
            MajorExample.Criteria criteria = majorExample.createCriteria();
            criteria.andMnameEqualTo(majorName);
            criteria.andCoidEqualTo(coid);
            List<Major> majorList = majorMapper.selectByExample(majorExample);
            if (majorList != null) {
                Major major = majorList.get(0);
                redisTemplate.boundHashOps("major").put(major.getCoid()+"|"+major.getMname(), major.getMid());
                return major.getMid();
            }
        }
        return (Integer) majorId;
    }

    @Override
    public Integer getClassesIdByName(String classesName, Integer majorId) {
        Object classesId = redisTemplate.boundHashOps("classes").get(majorId + "|" + classesName);
        if (classesId == null) {
            ClassesExample classesExample = new ClassesExample();
            ClassesExample.Criteria criteria = classesExample.createCriteria();
            criteria.andMidEqualTo(majorId);
            criteria.andCnameEqualTo(classesName);
            List<Classes> classes = classesMapper.selectByExample(classesExample);
            if (classes != null) {
                Classes cbean = classes.get(0);
                redisTemplate.boundHashOps("classes").put(cbean.getMid() + "|" + cbean.getCname(), cbean.getCid());
                return  cbean.getCid();
            }
        }
        return (Integer) classesId;
    }
}
