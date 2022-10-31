package com.atguigu.flinkrealtimeweb.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TestScoreStageBean {
    String courseName;

    Integer from0To10;
    Integer from10To20;
    Integer from20To30;
    Integer from30To40;
    Integer from40To50;
    Integer from50To60;
    Integer from60To70;
    Integer from70To80;
    Integer from80To90;
    Integer from90To100;
}
