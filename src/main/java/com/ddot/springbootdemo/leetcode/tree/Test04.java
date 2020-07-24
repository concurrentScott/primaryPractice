package com.ddot.springbootdemo.leetcode.tree;

/**
 * 判断一颗书是否为平衡二叉树
 */
public class Test04 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (!isBalanced(root.right) || !isBalanced(root.left)) return false;
        if (Math.abs(treeDepth(root.right) - treeDepth(root.left)) > 1) return false;
        return true;
    }
    private int treeDepth(TreeNode treeNode){
        if (treeNode == null) return 0;
        return Math.max(treeDepth(treeNode.left),treeDepth(treeNode.right));
    }

}
