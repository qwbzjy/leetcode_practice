package com.category.linked;

/**
 * @Author qiwenbo
 * @Date 2021/7/31 11:10
 * @Description 栈基本操作
 **/
public class ArrayStack {

    static final int CAPACITY = 1000;
    int top;
    int stack[];

    public ArrayStack() {
        top = -1;
        stack = new int[CAPACITY];
    }

    /**
     * 入栈
     */
    public boolean push(int val) {
        if (top >= (CAPACITY - 1)) {
            System.out.println("stack overflow");
            return false;
        }
        stack[++top] = val;
        return true;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (top < 0) {
            System.out.println("stack underflow");
            return 0;
        }
        int element = stack[top--];
        return element;
    }

    /**
     * 栈顶元素出栈
     */
    public int peek() {
        if (top < 0) {
            System.out.println("stack underflow");
            return 0;
        }
        int element = stack[top];
        return element;
    }

    /**
     * 判空
     */
    public boolean isEmpty() {
        return top < 0;
    }
}
