package com.atguigu.flinkrealtimeweb.service;

import com.atguigu.flinkrealtimeweb.bean.TestScoreStageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {
    public Long getTestUserNumber(Long dt);

    Double getAvgScore(Long dt);

    Double getAvgTime(Long dt);

    List<TestScoreStageBean> getScoreStage(Long dt);
}
