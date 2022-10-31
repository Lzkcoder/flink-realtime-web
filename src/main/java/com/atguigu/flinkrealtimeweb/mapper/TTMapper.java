package com.atguigu.flinkrealtimeweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TTMapper {

    @Select("select 'hello world'")
    String  getTest(String s);
}
