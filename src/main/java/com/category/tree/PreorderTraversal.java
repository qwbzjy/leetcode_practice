package com.category.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author qiwenbo
 * @Date 2021/7/19 21:52
 * @Description 二叉树前序遍历递归写法
 **/
public class PreorderTraversal {

        public List<Integer> preorderTraversal(InOrderTraversal.TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            preorder(root, res);
            return res;
        }

        public void preorder(InOrderTraversal.TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }


}




