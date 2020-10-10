package com.ddot.springbootdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapper {


    @Select({
            "select data_content from scott_api_content where id = #{id}"
    })
    String selectApiContent(@Param("id") String id);



}
