package com.atguigu.flinkrealtimeweb.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TrafficOrderWithProvinceBean {
    String provinceName;
    String amount;
}
