package com.atguigu.flinkrealtimeweb.service.impl;


import com.atguigu.flinkrealtimeweb.bean.TestScoreStageBean;
import com.atguigu.flinkrealtimeweb.service.TestService;
import com.atguigu.flinkrealtimeweb.mapper.TestPaperMapper;
import com.atguigu.flinkrealtimeweb.mapper.TestScoreStageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestPaperMapper testPaperMapper;
    @Autowired
    TestScoreStageMapper testScoreStageMapper;
    @Override
    public Long getTestUserNumber(Long dt) {
        return testPaperMapper.getTestUserNumber(dt);
    }

    @Override
    public Double getAvgScore(Long dt) {
        return testPaperMapper.getTotalScore(dt)/testPaperMapper.getTotalUserNumber(dt);
    }

    @Override
    public Double getAvgTime(Long dt) {
        return testPaperMapper.getTotalTime(dt)/testPaperMapper.getTotalUserNumber(dt);
    }

    @Override
    public List<TestScoreStageBean> getScoreStage(Long dt) {
        return testScoreStageMapper.getScoreStage(dt);
    }
}
