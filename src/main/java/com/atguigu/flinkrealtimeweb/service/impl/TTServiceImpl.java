package com.atguigu.flinkrealtimeweb.service.impl;

import com.atguigu.flinkrealtimeweb.mapper.TTMapper;
import com.atguigu.flinkrealtimeweb.service.TTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TTServiceImpl implements TTService {

    @Autowired
    TTMapper ttMapper;
    @Override
    public String getWords(String s) {
        String result = ttMapper.getTest(s);
        String s1 = "result" + result;
        return s1;
    }
}
