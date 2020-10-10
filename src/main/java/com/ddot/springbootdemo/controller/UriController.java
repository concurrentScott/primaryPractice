package com.ddot.springbootdemo.controller;


import com.ddot.springbootdemo.Test.JsonNodeUtils;
import com.ddot.springbootdemo.service.DataService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UriController {

    @Autowired
    DataService dataService;

    @GetMapping("/uri/select")
    public ServerResponse selectValue(){
        JsonNode apiContent = dataService.getApiContent("1");


        return ServerResponse.createServerResponseBySuccess(apiContent);

    }

    @GetMapping("/uri/mutiSelect")
    public ServerResponse<JsonNode> receiveMessage(){

        JsonNode apiContent = dataService.getApiContent("2");

        return ServerResponse.createServerResponseBySuccess(apiContent);

    }





}
