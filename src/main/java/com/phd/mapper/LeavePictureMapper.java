package com.phd.mapper;

import com.phd.entity.LeavePicture;
import com.phd.entity.LeavePictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeavePictureMapper {
    long countByExample(LeavePictureExample example);

    int deleteByExample(LeavePictureExample example);

    int insert(LeavePicture record);

    int insertSelective(LeavePicture record);

    List<LeavePicture> selectByExample(LeavePictureExample example);

    int updateByExampleSelective(@Param("record") LeavePicture record, @Param("example") LeavePictureExample example);

    int updateByExample(@Param("record") LeavePicture record, @Param("example") LeavePictureExample example);
}