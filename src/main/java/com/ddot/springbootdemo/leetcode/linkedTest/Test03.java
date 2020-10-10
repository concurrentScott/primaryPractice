package com.ddot.springbootdemo.leetcode.linkedTest;

public class Test03 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode first = l1;
        ListNode second = l2;
        ListNode current = start;
        int increase  =  0;
        while(first != null || second != null){
            int f = first == null ? 0 : first.val;
            int s = second == null ? 0: second.val;
            int count = f + s + increase;
            increase = count / 10;
            current.next = new ListNode(count % 10);
            current = current.next;
            if(first.next != null)first = first.next;
            if(second.next != null)second = second.next;
        }
        if(increase > 0){
            current.next = new ListNode(increase)  ;
        }
        return start.next;
    }
    public ListNode addTwoNumb(ListNode l1 ,ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }

    public static void main(String[] args) {

    }
}
