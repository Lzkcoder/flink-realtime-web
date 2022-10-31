package com.atguigu.flinkrealtimeweb.mapper;

import com.atguigu.flinkrealtimeweb.bean.TestScoreStageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestScoreStageMapper {
    @Select("select paper_name" +
          ",sum(if(left(distribution,1)='0',uv_ct,0)) as from0To10" +
          ",sum(if(left(distribution,1)='1',uv_ct,0)) as from10To20" +
          ",sum(if(left(distribution,1)='2',uv_ct,0)) as from20To30" +
          ",sum(if(left(distribution,1)='3',uv_ct,0)) as from30To40" +
          ",sum(if(left(distribution,1)='4',uv_ct,0)) as from40To50" +
          ",sum(if(left(distribution,1)='5',uv_ct,0)) as from50To60" +
          ",sum(if(left(distribution,1)='6',uv_ct,0)) as from60To70" +
          ",sum(if(left(distribution,1)='7',uv_ct,0)) as from70To80" +
          ",sum(if(left(distribution,1)='8',uv_ct,0)) as from80To90" +
          ",sum(if(left(distribution,1)='9',uv_ct,0)) as from90To100" +
          " from dws_paper_score_distribution_window where toYYYYMMDD(window_start) = #{dt} group by paper_name")
    List<TestScoreStageBean> getScoreStage(Long dt);
}
//    Missing columns: 'stt' while processing query: 'SELECT paper_name, sum(if(substring(distribution, 1, 1) = '0', uv_ct, 0)) AS from0To10 FROM dws_paper_score_distribution_window WHERE toYYYYMMDD(stt) = 20221031 GROUP BY paper_name', required columns: 'paper_name' 'stt' 'uv_ct' 'distribution', source columns: 'distribution' 'paper_name' 'paper_id' 'ts' 'window_end' 'uv_ct' 'window_start'.


