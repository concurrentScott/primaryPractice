package com.ddot.springbootdemo.concurrencypractice.test.synccontainer;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotThreadSafe;

import java.util.Vector;

@NotThreadSafe
public class VactorExam {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        while (true) {

            /**因为操作顺序而造成数组越界的问题*/

            Thread t1 = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };
            Thread t2 = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };
            t1.start();
            t2.start();

        }

    }
}
