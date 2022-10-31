package com.atguigu.flinkrealtimeweb.controller;


import com.atguigu.flinkrealtimeweb.bean.TrafficKeyWordsBean;
import com.atguigu.flinkrealtimeweb.bean.TrafficUserWithChannelBean;
import com.atguigu.flinkrealtimeweb.service.TrafficService;
import com.atguigu.flinkrealtimeweb.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/traffic")
public class TrafficController {

    @Autowired
    TrafficService trafficService;


    @RequestMapping("/keywords")
    public StringBuffer getKeyWord(@RequestParam(value = "dt", required = false) String s) {

        if (s == null) {
            s = DateFormatUtil.toDate(System.currentTimeMillis());
        }
        String dt = s.replace("-", "");

        StringBuffer sb = new StringBuffer().append("{\n" +
              "    \"status\": 0,\n" +
              "    \"msg\": \"\",\n" +
              "    \"data\": [");
        StringBuffer sbTail = new StringBuffer().append("    ]\n" +
              "  }");

        List<TrafficKeyWordsBean> keyWords =
//              new ArrayList<>();
              trafficService.getKeyWords(dt);

//        keyWords.add(new TrafficKeyWordsBean("hello", 100));
//        keyWords.add(new TrafficKeyWordsBean("world", 100));
        for (int i = 0; i < keyWords.size(); i++) {
            if (i!=0) {
                sb.append(",");
            }
            sb.append("{\"name\":\"")
                  .append(keyWords.get(i).getKeyword())
                  .append("\",\"value\":")
                  .append(keyWords.get(i).getNumber())
                  .append("}");
        }
        return sb.append(sbTail);
    }

    @RequestMapping("/channel")
    public StringBuilder getUserWithChannel(@RequestParam(value = "dt", required = false) String s){
        if (s==null){
            s = DateFormatUtil.toDate(System.currentTimeMillis());
        }
        String dt = s.replace("-", "");


        StringBuilder sb = new StringBuilder().append("{\n" +
              "    \"status\": 0,\n" +
              "    \"msg\": \"\",\n" +
              "    \"data\": [");

        List<TrafficUserWithChannelBean> userWithChannel = trafficService.getUserWithChannel(dt);


        for (int i = 0; i < userWithChannel.size(); i++) {
            if (i != 0){
                sb.append(",");
            }
            sb.append("{ \"name\": \"")
                  .append(userWithChannel.get(i).getChannel())
                  .append("\", \"value\": ")
                  .append(userWithChannel.get(i).getUvCnt())
                  .append("}");
        }
        return sb.append("]\n" +
              "}");
    }
}
