package com.category.linked;

/**
 * @Author qiwenbo
 * @Date 2021/7/31 11:16
 * @Description TODO
 **/
public class LinkedStack {
    static class StackNode {
        int val;
        StackNode next;

        StackNode(int val) {
            this.val = val;
        }
    }

    StackNode top;

    public LinkedStack() {
        top = null;
    }

    /**
     * 入栈
     *
     * @param val
     */
    public void push(int val) {
        StackNode newNode = new StackNode(val);
        if (top == null) {
            top = newNode;
        } else {
            StackNode temp = top;
            top = newNode;
            newNode.next = temp;
        }
        System.out.println(val + " is pushed to stack");
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (top == null) {
            return Integer.MIN_VALUE;
        }
        int popped = top.val;
        top = top.next;
        return popped;
    }

    /**
     * 栈顶元素出栈
     *
     * @return
     */
    public int peek() {
        if (top == null) {
            System.out.println("stack is empty");
            return Integer.MIN_VALUE;
        }
        return top.val;
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == null;
    }
}
