package com.ddot.springbootdemo.leetcode.tree;

import com.ddot.springbootdemo.TestReflection.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test05 {
    /**
     * 从上到下遍历二叉树

    public int[] levelOrder(TreeNode root) {

        if(root == null){
            return new int[]{};
        }
        LinkedList<TreeNode> queue = new LinkedList();
        List<Integer> list = new ArrayList<>();
        queue.addLast(root);

        while (queue.size() > 0){
            TreeNode node = queue.pop();
            list.add(node.val);
            if (node.right != null) queue.addLast(node);
            if (node.left != null) queue.addLast(node);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }*/

    public  User user = new User("1","1",0);

    public volatile int temp = 1;
    AtomicInteger integer = new AtomicInteger();
    public static void main(String[] args) {
        Test05 t = new Test05();
        User user = t.user;
        int text = t.temp;
        AtomicInteger atomicInteger = t.integer;


        for (int i = 0; i < 100000; i++) {

            new Thread(() -> {
                user.setAge(atomicInteger.incrementAndGet());
                user.setAge(atomicInteger.decrementAndGet());
            }).start();
        }

        System.out.println(user);


    }

}
