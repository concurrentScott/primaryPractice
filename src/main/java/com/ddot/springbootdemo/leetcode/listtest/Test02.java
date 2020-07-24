package com.ddot.springbootdemo.leetcode.listtest;

public class Test02 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lA = headA;
        ListNode lB = headB;

        while (lA != lB){
            lA.next = lA.next == null ? lA.next : headB;
            lB.next = lB.next == null ? lB.next : headA;
        }
        return lA;

    }
}
