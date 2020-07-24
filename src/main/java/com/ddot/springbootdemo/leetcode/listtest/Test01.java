package com.ddot.springbootdemo.leetcode.listtest;

public class Test01 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        System.out.println(new Test01().reverseList(listNode));

    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode now = head;
        ListNode next = null;

        while (now != null){
            //赋值
            next = now.next;
            now.next = pre;

            //两个指针都向前一步
            pre = now;
            now = next;


        }
        return pre;


    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val + "";
    }
}