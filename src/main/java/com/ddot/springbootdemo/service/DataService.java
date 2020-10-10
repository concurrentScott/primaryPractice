package com.ddot.springbootdemo.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface DataService {


    JsonNode getApiContent(String id);

}
