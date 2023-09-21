package com.anynum.demo.structure;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class StructureDemo {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        LinkedList<String> list = new LinkedList<>();
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        CopyOnWriteArrayList<String> cow = new CopyOnWriteArrayList();
    }
}
