package com.category.linked;

/**
 * @Author qiwenbo
 * @Date 2021/7/31 9:56
 * @Description 链表基本操作
 **/
public class LinkedList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;
    ListNode tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 插入
     *
     * @param position
     * @param number
     */
    public void insert(int position, int number) {
        if (position > size) {
            return;
        }
        ListNode newNode = new ListNode(number);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            size++;
        } else if (position == size) {
            this.append(number);
        } else {
            ListNode pre = head;
            for (int i = 0; i < position; i++) {
                pre = pre.next;
            }
            ListNode next = pre.next;
            newNode.next = next;
            pre.next = newNode;
            size++;
        }
    }

    public void append(int number) {
        ListNode newNode = new ListNode(number);
        if (tail == null) {
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * 删除
     *
     * @param number
     */
    public void delete(int number) {
        if (head != null && head.val == number) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = head;
            }
        } else {
            ListNode pre = head;
            ListNode cur = head;
            while (pre != null && cur != null) {
                if (cur.val == number) {
                    if (cur == tail) {
                        tail = pre;
                    }
                    pre.next = cur.next;
                    size--;
                    return;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    /**
     * 查找
     *
     * @param number
     * @return
     */
    public int search(int number) {
        ListNode cur = head;
        for (int index = 0; cur != null; index++) {
            if (cur.val == number) {
                return index;
            }
            cur = cur.next;
        }
        return -1;
    }

    /**
     * 更新
     *
     * @param oldValue
     * @param newValue
     * @return
     */
    public int update(int oldValue, int newValue) {
        ListNode cur = head;
        for (int i = 0; cur != null; i++) {
            if (cur.val == oldValue) {
                cur.val = newValue;
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }
}
