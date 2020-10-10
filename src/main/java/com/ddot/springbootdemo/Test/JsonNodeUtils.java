package com.ddot.springbootdemo.Test;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonNodeUtils {
    private static final ObjectMapper mapper ;
    static {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static JsonNode parseStringToJson(String text) {
        try {
            return mapper.readTree(text);
        } catch (IOException e) {
            log.error("String 转换成 JsonNode 失败");
        }
        return null;
    }

    public static <T> T parseToTargetObject(String text, Class<T> valueType){
        try {
            return mapper.readValue(text, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> parseToTargetList(String text, Class<T> valueType){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode        = objectMapper.readTree(text);
            JavaType jt                     = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, valueType);
            return  objectMapper.readValue((DataInput)jsonNode, jt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<String> getObjectNodeKet(ObjectNode data) {
        Iterator<String> keyIterator = data.fieldNames();
        List<String> keyList = Lists.newArrayList();
        while(keyIterator.hasNext()){
            keyList.add(keyIterator.next());
        }
        return keyList;
    }

    public static String writeObjectToString(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error("Object 转换成 String 失败");
        }
        return null;
    }
    public static JsonNode writeObjectToNode(Object o){
        try {
            return mapper.convertValue(o, JsonNode.class);
        }catch (IllegalArgumentException e){
            log.error("Object 转换成 String 失败");
        }
        return null;
    }

    public static ObjectMapper getMapper(){
        return mapper;
    }

    public static void main(String[] args) {

        String data = "[{\"label\":\"urlurl\",\"value\":\"1\"}]";

        JsonNode node = JsonNodeUtils.parseStringToJson(data);
        System.out.println(node);

    }
}
