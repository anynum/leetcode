package com.alibaba.coin.demo.structure;

import leetcode.editor.cn.entity.ListNode;

import java.util.EmptyStackException;

/* 基于链表实现的队列 */
class LinkedListQueue {
    private ListNode front, rear;  // 头结点 front ，尾结点 rear 
    private int queSize = 0;

    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    /* 获取队列的长度 */
    public int size() {
        return queSize;
    }

    /* 判断队列是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* 入队 */
    public void offer(int num) {
        // 尾结点后添加 num
        ListNode node = new ListNode(num);
        // 如果队列为空，则令头、尾结点都指向该结点
        if (front == null) {
            front = node;
            rear = node;
            // 如果队列不为空，则将该结点添加到尾结点后
        } else {
            rear.next = node;
            rear = node;
        }
        queSize++;
    }

    /* 出队 */
    public int poll() {
        int num = peek();
        // 删除头结点
        front = front.next;
        queSize--;
        return num;
    }

    /* 访问队首元素 */
    public int peek() {
        if (size() == 0)
            throw new EmptyStackException();
        return front.val;
    }
}
