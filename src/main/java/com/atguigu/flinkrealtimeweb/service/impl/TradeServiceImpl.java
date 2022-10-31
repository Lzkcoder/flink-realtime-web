package com.atguigu.flinkrealtimeweb.service.impl;

import com.atguigu.flinkrealtimeweb.bean.TrafficOrderWithProvinceBean;
import com.atguigu.flinkrealtimeweb.mapper.TradeMapper;

import com.atguigu.flinkrealtimeweb.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    TradeMapper mapper;


    @Override
    public List<TrafficOrderWithProvinceBean> getOrderCount(String dt) {
        return mapper.getOrderAmount(Long.valueOf(dt));

    }
}
