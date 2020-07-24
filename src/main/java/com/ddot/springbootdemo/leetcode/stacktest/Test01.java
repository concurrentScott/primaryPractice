package com.ddot.springbootdemo.leetcode.stacktest;

import java.util.LinkedList;

/**
 * 两个栈形成一个队列
 */
public class Test01 {

}
class CQueue {
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;
    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);

    }

    public int deleteHead() {
        if (stack1.size() == 0 && stack2.size() == 0){
            return -1;
        }
        if (stack1.size() != 0 && stack2.size() == 0){
            while (stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        int res = stack2.pop();
        return res;

    }
}