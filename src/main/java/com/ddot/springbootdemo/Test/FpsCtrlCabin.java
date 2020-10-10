package com.ddot.springbootdemo.Test;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class FpsCtrlCabin {

    private String tranData;
    private String busiCate;
    private String targetCode;
    private String targetName;
    private String targetValue;


    public FpsCtrlCabin build(){

        if (targetCode.indexOf("-") > 0){
            String[] split = this.targetCode.split("-");

            this.setTargetCode(split[0]);
            this.setTargetName(split[1]);

        }
        return this;
    }

    public FpsCtrlCabin(String tranData, String busiCate) {
        this.tranData = tranData;
        this.busiCate = busiCate;
    }

    public static void main(String[] args) {
        /*List<Date> dateList = Lists.newArrayList();

        Map<Date,List<FpsCtrlCabin>> cbMap = Maps.newHashMap();

        for (Date date : dateList) {
            List<FpsCtrlCabin> cbList = daoSupport.select(date);
            cbMap.put(date,cbList);
        }

        List<HashMap<String,String>> res = Lists.newArrayList();



        for (Date date : cbMap.keySet()) {
            HashMap<String,String> temp = Maps.newHashMap();
            temp.put("data",date.toString());


            *//*Map<String, String> collect = cbMap.get(date).stream().
                    collect(Collectors.toMap(FpsCtrlCabin::getTargetName, FpsCtrlCabin::getTargetValue));

            temp.putAll(collect);*//*

            temp.put(cbMap.get(date).get(1).getTargetName(),cbMap.get(date).get(1).getTargetValue());
            temp.put(cbMap.get(date).get(2).getTargetName(),cbMap.get(date).get(2).getTargetValue());
            temp.put(cbMap.get(date).get(3).getTargetName(),cbMap.get(date).get(3).getTargetValue());
            temp.put(cbMap.get(date).get(4).getTargetName(),cbMap.get(date).get(4).getTargetValue());
            temp.put(cbMap.get(date).get(5).getTargetName(),cbMap.get(date).get(5).getTargetValue());
            temp.put(cbMap.get(date).get(6).getTargetName(),cbMap.get(date).get(6).getTargetValue());
            temp.put(cbMap.get(date).get(7).getTargetName(),cbMap.get(date).get(7).getTargetValue());


            res.add(temp);
        }*/


       /* List<FpsCtrlCabin> list = Lists.newArrayList();

        list.add(new FpsCtrlCabin("11","aa"));
        list.add(new FpsCtrlCabin("22","bb"));
        list.add(new FpsCtrlCabin("33","cc"));
        Map<String, String> collect = list.stream().
                collect(Collectors.toMap(FpsCtrlCabin::getTranData, FpsCtrlCabin::getBusiCate));



        System.out.println(collect);
*/

        String date1 = "20200810";
        String date2 = "20200811";

        String sql = "select tran_data,target_value from cabin " +
                "where target_name = #{name} and tran_date between #{startTime} and #{endTime}";

       // List<FpsCtrlCabin> cbList = daoSupport.select(name,startTime,endTime);




        List<HashMap<String,Object>> res = Lists.newArrayList();

        List<String> nameList = Lists.newArrayList();

        List<String> dateList = Lists.newArrayList();

        for (int i = 0; i < nameList.size(); i++) {
            HashMap<String, Object> item = Maps.newHashMap();
            item.put("name", nameList.get(i));

            List<HashMap<String, String>> dataList = Lists.newArrayList();
            for (int j = 0; j < dateList.size(); j++) {
                HashMap<String, String> inner = Maps.newHashMap();
                /*FpsCtrlCabin cabin = daoSupport.select(nameList.get(i),dateList.get(j));
                if (null == cabin){
                    cabin.setTargetValue("0");
                }
                inner.put("date",cabin.getTranData());
                inner.put("value",cabin.getTargetValue());
                dataList.add(inner);
            }
*/
                item.put("data", dataList);

                res.add(item);
            }


        }
    }

}

