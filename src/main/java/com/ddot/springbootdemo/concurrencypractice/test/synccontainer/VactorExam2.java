package com.ddot.springbootdemo.concurrencypractice.test.synccontainer;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotThreadSafe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@NotThreadSafe
public class VactorExam2 {

    //Exception in thread "main" java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> vector){
        vector.forEach(
                integer -> {
                    if (3 == integer){
                        vector.remove(integer);
                    }
                }
        );
    }
    private static void test11(List<Integer> list){
        list.forEach(
                integer -> {
                    if (3 == integer){
                        list.remove(integer);
                    }
                }
        );
    }
    private static void test11(CopyOnWriteArrayList<Integer> list){
        list.forEach(
                integer -> {
                    if (3 == integer){
                        list.remove(integer);
                    }
                }
        );
    }

    //Exception in thread "main" java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> vector){  //迭代器
        Iterator<Integer> it = vector.iterator();
        while (it.hasNext()){
            int temp = it.next();
            if (temp == 3){
                vector.remove(temp);
            }
        }
    }

    private static void test21(CopyOnWriteArrayList<Integer> vector){  //迭代器
        Iterator<Integer> it = vector.iterator();
        while (it.hasNext()){
            int temp = it.next();
            if (temp == 3){
                vector.remove(temp);
            }
        }
    }

    private static void test22(CopyOnWriteArraySet<Integer> vector){  //迭代器
        Iterator<Integer> it = vector.iterator();
        while (it.hasNext()){
            int temp = it.next();
            if (temp == 3){
                vector.remove(temp);
            }
        }
    }

    //成功！
    private static void test3(Vector<Integer> vector){

        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i) == 3){
                vector.remove(i);
            }
        }

    }

    //Exception in thread "main" java.util.ConcurrentModificationException
    private static void test4(Vector<Integer> vector){

        for (Integer integer : vector) {
            if (integer == 3){
                vector.remove(integer);
            }
        }
        }

    private static void test41(CopyOnWriteArrayList<Integer> list){

        for (Integer integer : list) {
            if (integer == 3){
                list.remove(integer);
            }
        }
    }


        public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        CopyOnWriteArrayList<Integer> list1 = new CopyOnWriteArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
        set.add(1);
        set.add(2);
        set.add(3);

       // test1(vector);
        //test11(list);
        //test41(list1);
            //test11(list1);
            //test21(list1);
        test22(set);
            System.out.println(set);
    }
}
