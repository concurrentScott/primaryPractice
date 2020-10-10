package com.ddot.springbootdemo.leetcode.linkedTest;

public class Test02 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        for(int i = 0;i < n; i++){
            first = first.next;
        }
        if(first == null){
            return head.next;
        }
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return head;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(5);

        ListNode head = listNode;

        removeNthFromEnd(listNode,2);
    }
}
