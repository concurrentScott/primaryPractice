package com.ddot.springbootdemo.leetcode.tree;

import java.util.*;

/**
 * 二叉树的最近公共父亲
 */
public class Test02 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //标记父亲节点的map
        Map<TreeNode,TreeNode> markParent = new HashMap<>();

        markParent.put(root,null);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //先找到两个节点
        while (!markParent.containsKey(p) || !markParent.containsKey(q)){
            //做一个层序遍历
            TreeNode node = queue.poll();
            if (node.left != null){
                markParent.put(node.left,node);
                queue.addLast(node.left);
            }
            if (node.right != null){
                markParent.put(node.right,node);
                queue.addLast(node.right);
            }
        }
        Set<TreeNode> ancestor = new HashSet<>();
        //记录p和他的祖先节点，从p一直到root
        while (p != null){
            ancestor.add(p);
            p = markParent.get(p);
        }

        while (!ancestor.contains(q)){
            q = markParent.get(q);
        }
        return q;
    }

    //递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        return null;
    }

    }
