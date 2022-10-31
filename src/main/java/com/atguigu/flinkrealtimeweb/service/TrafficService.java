package com.atguigu.flinkrealtimeweb.service;

import com.atguigu.flinkrealtimeweb.bean.TrafficKeyWordsBean;
import com.atguigu.flinkrealtimeweb.bean.TrafficUserWithChannelBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrafficService {


    List<TrafficKeyWordsBean> getKeyWords(String dt);

    List<TrafficUserWithChannelBean> getUserWithChannel(String dt);
}
