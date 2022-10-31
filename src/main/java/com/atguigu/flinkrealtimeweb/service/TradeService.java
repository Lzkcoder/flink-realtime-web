package com.atguigu.flinkrealtimeweb.service;

import com.atguigu.flinkrealtimeweb.bean.TrafficOrderWithProvinceBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TradeService {


    List<TrafficOrderWithProvinceBean> getOrderCount(String dt);
}
