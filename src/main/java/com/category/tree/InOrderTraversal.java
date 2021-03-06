package com.category.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qiwenbo
 * @Date 2021/7/19 21:41
 * @Description 递归方式中序遍历二叉树，1、递推公式 2，终止条件;
 * 每道题写完，必须分析下时间复杂度与空间复杂度
 **/
public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;

    }

    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);

    }

    //0730
    // 中序
    public void inOrder_01(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder_01(root.left, res);
        res.add(root.val);
        inOrder_01(root.right, res);
    }

    // 前序
    public void inOrder_02(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        inOrder_02(root.left, res);
        inOrder_02(root.right, res);
    }

    //后序
    public void inOrder_03(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder_03(root.left, res);
        inOrder_03(root.right, res);
        res.add(root.val);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        ;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
