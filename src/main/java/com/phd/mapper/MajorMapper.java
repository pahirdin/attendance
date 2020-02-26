package com.phd.mapper;

import com.phd.entity.Major;
import com.phd.entity.MajorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MajorMapper {
    long countByExample(MajorExample example);

    int deleteByExample(MajorExample example);

    int insert(Major record);

    int insertSelective(Major record);

    List<Major> selectByExample(MajorExample example);

    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example);

    /**
     * 新增专业 返回主键
     * @param major 新增数据
     * @return 更新数量  并在major里附带新增时的主键
     */
    int insertOne(Major major);
}