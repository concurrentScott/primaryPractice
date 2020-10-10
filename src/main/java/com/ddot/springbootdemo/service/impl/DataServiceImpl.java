package com.ddot.springbootdemo.service.impl;

import com.ddot.springbootdemo.Test.JsonNodeUtils;
import com.ddot.springbootdemo.mapper.DataMapper;
import com.ddot.springbootdemo.service.DataService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataMapper dataMapper;

    @Override
    public JsonNode getApiContent(String id) {

        String res = dataMapper.selectApiContent(id);

        return JsonNodeUtils.parseStringToJson(res);


    }
}
