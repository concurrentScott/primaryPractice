package com.ddot.springbootdemo.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize()
@Data
public class ServerResponse<T> {
    private int status;    //状态 0 成功
    private T data;         //status为0 将返回的数据封装
    private String msg;     //提示信息

    private ServerResponse(){}
    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status, T data){
        this.status = status;
        this.data = data;
    }
    private ServerResponse(int status, T data, String msg){
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public boolean ifSuccess(){
        return this.status == 200;
    }

    //封装 返回的对象 成功 失败
    public static ServerResponse createServerResponseBySuccess(){
        return new ServerResponse(200);
    }

    public static <T> ServerResponse createServerResponseBySuccess(T data){
        return new ServerResponse(200,data);
    }

    public static <T> ServerResponse createServerResponseByFail(int status){
        return new ServerResponse(status);
    }
    public static <T> ServerResponse createServerResponseByFail(int status, String msg){
        return new ServerResponse(status,null,msg);
    }

}
