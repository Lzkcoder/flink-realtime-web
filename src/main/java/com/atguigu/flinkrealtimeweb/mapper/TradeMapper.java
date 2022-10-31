package com.atguigu.flinkrealtimeweb.mapper;

import com.atguigu.flinkrealtimeweb.bean.TrafficOrderWithProvinceBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TradeMapper {
    @Select("select province_name,sum(cast(order_money as decimal(16,2) )) as amount from dws_course_order_situation where toYYYYMMDD(curdate) = #{dt} group by province_name")
    List<TrafficOrderWithProvinceBean> getOrderAmount(Long dt);
}

