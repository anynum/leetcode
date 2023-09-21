package leetcode.editor.cn.datastructure;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheV2 {
    class Node{
        int val, key;
        Node pre, next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    int size;
    Node head, tail;
    Map<Integer, Node> map;
    public LRUCacheV2(int size){
        this.size = size;
        head = new Node(-1,-1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>(size);
    }

    public void put(int key, int value){
        Node node  = null;
        if (map.containsKey(key)){
            node  = map.get(key);
            node.val = value;
        } else {
            if (map.size() == size){
                Node del = tail.pre;
                map.remove(del.key);
                delete(del);
            }
            node = new Node(key, value);
            map.put(key,node);
        }
        refresh(node);
    }

    public int get(int key){
        if (map.containsKey(key)){
            Node node = map.get(key);
            refresh(node);
            return node.val;
        }
        return -1;
    }

    private void refresh(Node node) {
        delete(node);
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }

    public void delete(Node node) {
        if (node.pre != null){
            Node pre = node.pre;
            node.next.pre = pre;
            pre.next = node.next;
        }
    }

}
