package com.category.tree;

/**
 * @Author qiwenbo
 * @Date 2021/7/20 11:13
 * @Description 节点高度 = 节点到叶子节点的最长路径(边数)
 * 节点的深度 = 根节点到这个节点所经历的边的个数
 * 节点的层数 = 节点的深度 +1
 * 树的高度= 根节点的高度
 * 高度、深度从0开始
 **/
public class TreeDemo {

    private Node root;

    /**
     * 插入新节点, 这里循环有问题//todo
     *
     * @param value
     */
    public void insert(int value) {
        Node newNode = new Node(value);
        Node cur = root;
        if (root == null) {
            root = newNode;
        } else {
            while (cur != null) {
                if (cur.val > value) {
                    if (cur.left == null) {
                        cur.left = newNode;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if (cur.right == null) {
                        cur.right = newNode;
                    } else {
                        cur = cur.right;
                    }
                }
            }
        }
    }

    public Node insertIntoBST(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        Node cur = root;
        Node p = root;
        while (cur != null) {
            p = cur;
            if (val > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (val > p.val) {
            p.right = new Node(val);
        } else {
            p.left = new Node(val);
        }
        return root;
    }

    /**
     * 查找节点
     */
    public Node find(int val) {
        if (root == null) {
            return null;
        } else {
            Node cur = root;
            while (cur.val != val) {
                if (cur.val > val) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
                if (cur == null) {
                    return null;
                }
            }
            return cur;
        }
    }

    /**
     * 删除节点
     */
    public boolean delete(int val) {
        Node cur = root;
        Node parent = cur;
        boolean isLeft = true;
        //1、先找到删除的节点
        while (cur.val != val) {
            parent = cur;
            if (cur.val > val) {
                cur = cur.left;
                isLeft = true;
            } else if (cur.val < val) {
                cur = cur.right;
                isLeft = false;
            }
            if (cur == null) {
                return false;
            }
        }
        //2、删除节点有3种类型, 1-无子节点  2-有一个子节点  3-有两个子节点
        if (cur.left == null && cur.right == null) {
            if (cur == root) {
                root = null;
            }
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            }
            if (isLeft) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            }
            if (isLeft) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else {
            Node successor = getSuccessor(cur);
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

    private Node getSuccessor(Node delNode) {
        Node successor = delNode;
        Node successorParent = delNode;
        Node cur = delNode.right;
        while (cur != null) {
            successorParent = successor;
            successor = cur;
            cur = cur.left;
        }
        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    public void list() {
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        System.out.println(node.val + " ");
        inOrderTraverse(node.right);
    }

    public int getHeight() {
        return getHeight(root);
    }

    /**
     * 高度
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return left > right ? left + 1 : right + 1;

    }

    public int getNodeNum() {
        return getNodeNum(root);
    }

    /**
     * 节点数
     *
     * @param node
     * @return
     */
    private int getNodeNum(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + getNodeNum(node.left) + getNodeNum(node.right);
    }

    public static void main(String[] args) {
        TreeDemo tree = new TreeDemo();
        int[] arr = new int[]{5, 3, 4, 1, 12, 15, 9, 8, 6, 7, 10, 13, 14, 30};
        tree.root = new Node(1);

        for (int i = 0; i < arr.length; i++) {
            tree.root = tree.insertIntoBST(tree.root, arr[i]);
        }
        tree.list();
        System.out.println("=================");
//        System.out.println(tree.delete(12));
//        tree.list();
        System.out.println(tree.getHeight());
        //高度打印出来是7, 但是实际画出来是6  todo
    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}