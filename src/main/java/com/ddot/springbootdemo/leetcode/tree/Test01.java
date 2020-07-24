package com.ddot.springbootdemo.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test01 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.addLast(root);

        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();

            //遍历一层的节点  queue的数量会一直增加，所以一开始要定好
            for (int i = queue.size(); i > 0; i--) {
                TreeNode treeNode = queue.removeFirst();
                temp.add(treeNode.val);
                if (treeNode.left != null)queue.addLast(treeNode.left);
                if (treeNode.right != null)queue.addLast(treeNode.right);
            }
            res.add(temp);
        }
        return res;



    }

}
