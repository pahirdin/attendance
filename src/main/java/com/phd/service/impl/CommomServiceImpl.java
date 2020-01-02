package com.phd.service.impl;

import com.phd.entity.*;
import com.phd.mapper.CheckTempMapper;
import com.phd.mapper.CollegeMapper;
import com.phd.mapper.MajorMapper;
import com.phd.service.ICommomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pahaied
 * @date 2019/12/19 17:04
 */
@Service
public class CommomServiceImpl implements ICommomService {
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private CheckTempMapper checkTempMapper;
    @Override
    public List<College> findAllCollege() {
        return this.collegeMapper.selectByExample(null);
    }

    @Override
    public List<Major> getMajorByCoid(Integer coid) {
        MajorExample majorExample = new MajorExample();
        MajorExample.Criteria criteria = majorExample.createCriteria();
        criteria.andCoidEqualTo(coid);
        return this.majorMapper.selectByExample(majorExample);
    }

    @Override
    public List<CheckTemp> queryTempListByRecordId(String recordId) {
        CheckTempExample checkTempExample = new CheckTempExample();
        CheckTempExample.Criteria criteria = checkTempExample.createCriteria();
        criteria.andRecordidEqualTo(recordId);
        return checkTempMapper.selectByExample(checkTempExample);
    }

    @Override
    public void saveTempTable(List<CheckTemp> tempList) {
        checkTempMapper.updateByBatch(tempList);
    }
}
