package com.category.linked;

/**
 * @Author qiwenbo
 * @Date 2021/7/31 11:28
 * @Description 基于链表实现队列
 **/
public class ListQueue {

    QueueNode front;
    QueueNode rear;

    static class QueueNode {
        int value;
        QueueNode next;

        public QueueNode(int value) {
            this.value = value;
        }
    }

    public void enqueue(int value) {
        QueueNode newNode = new QueueNode(value);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public int dequeue() {
        if (this.front == null) {
            System.out.println("the queue is empty");
            return Integer.MIN_VALUE;
        }
        QueueNode frontNode = this.front;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        return frontNode.value;
    }
}
