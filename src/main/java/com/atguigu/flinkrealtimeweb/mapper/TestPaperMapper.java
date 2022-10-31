package com.atguigu.flinkrealtimeweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestPaperMapper {

    @Select("select sum(test_user_number) from dwd_test_exam_total_score where toYYYYMMDD(stt) = #{dt}")
    public Long getTestUserNumber(Long dt);

    @Select("select sum(total_user_number) from dwd_test_exam_total_score where toYYYYMMDD(stt) = #{dt}")
    Double getTotalScore(Long dt);

    @Select("select sum(total_score) from dwd_test_exam_total_score where toYYYYMMDD(stt) = #{dt}")
    Double getTotalUserNumber(Long dt);

    @Select("select sum(total_time) from dwd_test_exam_total_time where toYYYYMMDD(stt) = #{dt}")
    Double getTotalTime(Long dt);
}
