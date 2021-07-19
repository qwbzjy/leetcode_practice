package com.category.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qiwenbo
 * @Date 2021/7/19 21:56
 * @Description 递归实现二叉树的后序遍历
 **/
public class PostorderTraversal {

    public List<Integer> postorderTraversal(InOrderTraversal.TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    public void postorder(InOrderTraversal.TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
