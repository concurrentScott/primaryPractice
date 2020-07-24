package com.ddot.springbootdemo.leetcode.linkedTest;
/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 */
public class Test01 {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(6);

        Test01 t = new Test01();
        System.out.println(t.deleteNode(node,5));
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        if (cur.val == val){
            return cur.next;
        }
        while (cur.val != val){
            pre = cur;
            cur = cur.next;
        }
        cur = cur.next;
        pre.next = cur;

        return head;
    }

}
