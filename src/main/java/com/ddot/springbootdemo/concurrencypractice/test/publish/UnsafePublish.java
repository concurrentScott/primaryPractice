package com.ddot.springbootdemo.concurrencypractice.test.publish;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] status = {"a","b","c"};

    //不安全发布，其他线程可能会更改，当真正需要使用这个值的时候，值已经不是确定的了
    public String[] getStatus(){
        return status;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStatus()));

        /**私有属性的修改*/
        unsafePublish.getStatus()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStatus()));

    }
}
