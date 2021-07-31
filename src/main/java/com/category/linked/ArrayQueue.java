package com.category.linked;

/**
 * @Author qiwenbo
 * @Date 2021/7/31 11:20
 * @Description 队列的基本操作
 **/
public class ArrayQueue {

    int front, rear, size;
    int capacity;
    int array[];

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        front = rear = size = 0;
        array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param item
     */
    public void enqueue(int item) {
        if (isFull()) {
            return;
        }
        array[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println(item + " is enqueued");
    }

    /**
     * 出队
     *
     * @return
     */
    public int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int item = array[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    /**
     * 队首元素出队
     *
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return array[front];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
