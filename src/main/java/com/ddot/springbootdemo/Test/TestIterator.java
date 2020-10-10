package com.ddot.springbootdemo.Test;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class TestIterator {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1","2","3","4","5");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
            String next = iterator.next();
            if (next.equals("1")){
                iterator.remove();
            }

        }
        System.out.println(list);



    }
}
