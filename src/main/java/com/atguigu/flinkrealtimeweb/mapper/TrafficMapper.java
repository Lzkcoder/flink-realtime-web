package com.atguigu.flinkrealtimeweb.mapper;

import com.atguigu.flinkrealtimeweb.bean.TrafficKeyWordsBean;
import com.atguigu.flinkrealtimeweb.bean.TrafficUserWithChannelBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrafficMapper {

    @Select("select keyword,sum( cast(keyword_count as int) ) as value from dws_traffic_source_keyword_page_view_window  where toYYYYMMDD(window_start) = #{dt} group by keyword")
    List<TrafficKeyWordsBean> getKeyWords(Long dt);

    @Select("select ch as channel,sum(uv_ct) as uvCnt from dws_traffic_vc_ch_ar_is_new_page_view_window where toYYYYMMDD(window_start) = #{dt} group by ch")
    List<TrafficUserWithChannelBean> getUserWithChannel(Long dt);
}
