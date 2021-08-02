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

    public void insert_0802(int position, int number) {
        if (position > size) {
            return;
        }
        ListNode newNode = new ListNode(number);
        if (position == 0) {
            //头插法
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            size++;
        } else if (position == size) {
            //尾插法
            if (tail == null) {
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        } else {
            //中间插入
            ListNode cur = head;
            for (int i = 0; i < position; i++) {
                if (cur != null) {
                    cur = cur.next;
                }
            }
            newNode.next = cur.next;
            cur.next = newNode;
            size++;

        }
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

    //0802
    public void delete_0802(int number) {
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

    //0802
    public int search_0802(int number) {
        ListNode cur = head;
        for (int i = 0; cur != null; i++) {
            if (cur.val == number) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    //0802
    public int search_0802_01(int number) {
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            if (cur.val == number) {
                return index;
            }
            cur = cur.next;
            index++;
        }
        return index;
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
