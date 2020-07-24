package com.ddot.springbootdemo.leetcode.stringtest;

import java.util.Stack;

/**
 * 寻找合法的括号
 *
 */
public class Test01 {
    public static void main(String[] args) {
        String a = "()";
        Test01 test01 = new Test01();
        System.out.println(test01.isValid(a));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();

    }

        

}
