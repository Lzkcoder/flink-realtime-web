package com.atguigu.flinkrealtimeweb.controller;

import com.atguigu.flinkrealtimeweb.bean.TestScoreStageBean;
import com.atguigu.flinkrealtimeweb.service.TestService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/test")
public class TestController {

    @Autowired
     TestService testService;

    @RequestMapping("/test1")
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/count/paper")
    public String getPaperTestCountWithPaper(@RequestParam(value = "dt",required = false)String s) {
        Long dt = Long.valueOf(s.replace("-", ""));
        //当天所有考试人数
        Long testUserNumber = testService.getTestUserNumber(dt);

        Double avgScore = testService.getAvgScore(dt);

        Double avgTime = testService.getAvgTime(dt);

        return "testUserNumber:"+testUserNumber+"AvgScore:"+avgScore+"AvgTime:"+avgTime;
    }

    @RequestMapping("/score/stage")
    public StringBuilder getTestScoreStage(@RequestParam(value = "dt",required = false)String s) {
        Long dt = Long.valueOf(s.replace("-", ""));
        List<TestScoreStageBean> scoreStage =
//              new ArrayList<>();
//        scoreStage.add(TestScoreStageBean.builder()
//                    .courseName("java")
//                    .from0To10(100)
//                    .from20To30(299)
//                    .from30To40(23)
//                    .from90To100(2999)
//                    .from40To50(38)
//                    .from50To60(23)
//                    .from60To70(231)
//              .build());
              testService.getScoreStage(dt);

        StringBuilder sb = new StringBuilder();
        sb.append("{\n" +
              "    \"status\": 0,\n" +
              "    \"msg\": \"\",\n" +
              "    \"data\": {\n" +
              "        \"total\":")
              .append(scoreStage.size())
              .append(",\"columns\": [\n" +
                    "            {\n" +
                    "                \"name\": \"试卷名\",\n" +
                    "                \"id\": \"course\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"name\": \"0-59\",\n" +
                    "                \"id\": \"6\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"name\": \"60-69\",\n" +
                    "                \"id\": \"7\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"name\": \"70-79\",\n" +
                    "                \"id\": \"8\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"name\": \"80-89\",\n" +
                    "                \"id\": \"9\"\n" +
                    "            }\n" +
                    "            ,{\n" +
                    "                \"name\": \"90-100\",\n" +
                    "                \"id\": \"10\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"superHeaders\": [\n" +
                    "            [\n" +
                    "                {\n" +
                    "                    \"name\": \"试卷名\\\\成绩分布\",\n" +
                    "                    \"colspan\": 1\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    \"name\": \"成绩分布\",\n" +
                    "                    \"colspan\": 5\n" +
                    "                }\n" +
                    "            ]\n" +
                    "        ],\n" +
                    "        \"rows\": [");
        for (int i = 0; i < scoreStage.size(); i++) {
            if(i != 0){
                sb.append(", ");
            }
            sb.append("{\"course\":\"")
                  .append(scoreStage.get(i).getCourseName().replace("\\","\\\\"))
                  .append("\",\"6\":\"")
                  .append(scoreStage.get(i).getFrom0To10()+scoreStage.get(i).getFrom20To30()+scoreStage.get(i).getFrom30To40()+scoreStage.get(i).getFrom40To50()+scoreStage.get(i).getFrom50To60())
                  .append("\",\"7\":\"")
                  .append(scoreStage.get(i).getFrom60To70())
                  .append("\",\"8\":\"")
                  .append(scoreStage.get(i).getFrom70To80())
                  .append("\",\"9\":\"")
                  .append(scoreStage.get(i).getFrom80To90())
                  .append("\",\"10\":\"")
                  .append(scoreStage.get(i).getFrom90To100())
                  .append("\"}");
        }


        return sb.append("]\n" +
              "    }\n" +
              "}");
    }
}
