package com.ddot.springbootdemo.concurrencypractice.test.escape;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

@Slf4j
@NotThreadSafe
public class Escape {

    /**
     * 该方法包含了对封装实例对隐含以及引用，对象构造完成之前，不能发布它
     * */
    private int thisCanBeEscape = 0;

    public Escape(){
       new InnerClass();

    }

    private class InnerClass{

        public InnerClass(){
            /**封装实例对引用*/
            log.info("{}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
