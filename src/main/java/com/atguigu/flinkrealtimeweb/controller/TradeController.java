package com.atguigu.flinkrealtimeweb.controller;

import com.atguigu.flinkrealtimeweb.bean.TrafficOrderWithProvinceBean;
import com.atguigu.flinkrealtimeweb.service.TradeService;

import com.atguigu.flinkrealtimeweb.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@ResponseBody
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @RequestMapping("/order/amount")
    public StringBuffer getOrderCountAmountGroupByProvince(@RequestParam(value = "dt", required = false) String s) {
        if (s == null) {
            s = DateFormatUtil.toDate(System.currentTimeMillis());
        }
        String dt = s.replace("-", "");
        StringBuffer sb = new StringBuffer().append("{" +
              " \"status\": 0," +
              " \"msg\": \"\"," +
              " \"data\": {" +
              " \"mapData\": [");

        StringBuffer sbTail = new StringBuffer().append("],\n" +
              " \"valueName\": \"销售额\"\n" +
              " }\n" +
              " }");

        List<TrafficOrderWithProvinceBean> orderCount =
//              new ArrayList<>();
//        orderCount.add(new TrafficOrderWithProvinceBean("北京","100000"));
              tradeService.getOrderCount(dt);


        for (int i = 0; i < orderCount.size(); i++) {

            if (i != 0) {
                sb.append(",");
            }
            sb.append("{\"name\":\"")
                  .append(orderCount.get(i).getProvinceName())
                  .append("\",\"value\":")
                  .append(orderCount.get(i).getAmount())
                  .append("}");
        }
        return sb.append(sbTail);
    }
}
