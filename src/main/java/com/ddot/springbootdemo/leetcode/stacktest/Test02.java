package com.ddot.springbootdemo.leetcode.stacktest;

import java.util.LinkedList;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 */
public class Test02 {
    private LinkedList<Integer> stackA; //主栈
    private LinkedList<Integer> stackB; //辅助栈，用来对最小元素记录
    public Test02() {
        stackA = new LinkedList<>();
        stackB = new LinkedList<>();
    }

    public void push(int x) {
        stackA.push(x);
        if (stackB.size() == 0 || stackB.peek() >= x){
            stackB.push(x);
        }

    }

    public void pop() {
        //pop时要保持 stackA和stackB的一致性
        if (stackA.pop().equals(stackB.peek())){
            stackB.pop();
        }

    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.pop();
    }
}
