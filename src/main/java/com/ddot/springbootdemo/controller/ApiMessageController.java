package com.ddot.springbootdemo.controller;


import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ApiMessageController {

    @PostMapping("/apiMessage")
    public void receiveMessage(@RequestBody JsonNode messageData){

        System.out.println(messageData);
        log.info("消息的结果为{}",messageData);

    }



}
