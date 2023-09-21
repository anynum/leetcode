package com.anynum.demo.structure;

import com.common.entity.ListNode;

import java.util.EmptyStackException;

/* 基于链表实现的栈 */
class LinkedListStack {
    private ListNode stackPeek;  // 将头结点作为栈顶
    private int stkSize = 0;   // 栈的长度

    public LinkedListStack() {
        stackPeek = null;
    }

    /* 获取栈的长度 */
    public int size() {
        return stkSize;
    }

    /* 判断栈是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* 入栈 */
    public void push(int num) {
        ListNode node = new ListNode(num);
        node.next = stackPeek;
        stackPeek = node;
        stkSize++;
    }

    /* 出栈 */
    public int pop() {
        int num = peek();
        stackPeek = stackPeek.next;
        stkSize--;
        return num;
    }

    /* 访问栈顶元素 */
    public int peek() {
        if (size() == 0)
            throw new EmptyStackException();
        return stackPeek.val;
    }
}
