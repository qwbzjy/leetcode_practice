package com.category.search;

/**
 * @Author qiwenbo
 * @Date 2021/7/31 11:53
 * @Description 二叉树
 **/
public class BTS {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private TreeNode root;

    /**
     * 插入节点，不允许重复节点
     *
     * @param key
     */
    public void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
            return;
        }
        TreeNode current = root;
        TreeNode parent = null;
        while (true) {
            parent = current;
            if (key < parent.value) {
                current = current.left;
                if (current == null) {
                    parent.left = new TreeNode(key);
                    return;
                }
            } else if (key > parent.value) {
                current = parent.right;
                if (current == null) {
                    parent.right = new TreeNode(key);
                    return;
                }
            } else {
                return;
            }
        }
    }

    /**
     * 查找节点
     *
     * @param key
     * @return
     */
    public TreeNode get(int key) {
        TreeNode cur = root;
        while (cur != null && cur.value != key) {
            if (key < cur.value) {
                cur = cur.left;
            } else if (key > cur.value) {
                cur = cur.right;
            }
        }
        return cur;
    }

    //删除
    public boolean delete(int key) {
        TreeNode parent = root;
        TreeNode cur = root;
        boolean isLeft = false;
        while (cur != null && cur.value != key) {
            parent = cur;
            if (cur.value > key) {
                isLeft = true;
                cur = cur.left;
            } else {
                isLeft = false;
                cur = cur.right;
            }
        }
        if (cur == null) {
            return false;
        }

        if (cur.left == null && cur.right == null) {
            if (cur == root) {
                root = null;
            } else if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = null;
            } else if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else {
            TreeNode successor = getSuccessor(cur);
            if (cur == root) {
                root = successor;
            } else if (isLeft) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = cur.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode successor = null;
        TreeNode successorParent = null;
        TreeNode cur = node.right;
        while (cur != null) {
            successorParent = successor;
            successor = cur;
            cur = cur.left;
        }
        if (successor != node.right) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }
        return successor;
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }
}
