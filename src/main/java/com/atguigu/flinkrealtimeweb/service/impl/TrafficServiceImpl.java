package com.atguigu.flinkrealtimeweb.service.impl;

import com.atguigu.flinkrealtimeweb.bean.TrafficKeyWordsBean;
import com.atguigu.flinkrealtimeweb.bean.TrafficUserWithChannelBean;
import com.atguigu.flinkrealtimeweb.mapper.TrafficMapper;
import com.atguigu.flinkrealtimeweb.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficServiceImpl implements TrafficService {

    @Autowired
    TrafficMapper trafficMapper;
    @Override
    public List<TrafficKeyWordsBean> getKeyWords(String dt) {
        return trafficMapper.getKeyWords(Long.valueOf(dt));
    }

    @Override
    public List<TrafficUserWithChannelBean> getUserWithChannel(String dt) {
        return trafficMapper.getUserWithChannel(Long.valueOf(dt));
    }
}
