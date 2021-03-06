package com.ddot.springbootdemo.concurrencypractice.test.immutable;



import com.ddot.springbootdemo.concurrencypractice.annoation.NotThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@NotThreadSafe
public class ImmutableExam1 {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public void test(final int a){
        //a = 1;//不许修改
    }

    public static void main(String[] args) {
        // a = 4; 编译不通过
        //map = Maps.newHashMap(); 不通过

        map.put(1,3);
    }


}
