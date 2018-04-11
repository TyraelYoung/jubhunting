package wang.tyrael.leetcode.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node{
        int key;
        int data;
        Node before;
        Node after;

        Node(){}

        Node(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }



    public Map<Integer, Node> map = new HashMap<>();
    public Node head = new Node(),
            tail = new Node();
    int capacity, occupy = 0;

    public LRUCache(int capacity) {
        head.after = tail;
        tail.before = head;

        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null? -1: node.data;
    }

    Node getNode(int key){
        Node node = map.get(key);
        if(node == null){
            return null;
        }else{
            //调整理历史
            node.before.after = node.after;
            node.after.before = node.before;

            head.after.before = node;
            head.after = node;

            return node;
        }
    }

    void doInsert(int key, int value){
        Node insert = new Node(key, value);
        map.put(key, insert);
        insert.after = head.after;
        insert.before = head;

        head.after.before = insert;
        head.after = insert;
    }

    public void put(int key, int value) {
        //历史已经更新
        Node node = getNode(key);
        if(node == null){
            if(occupy == capacity){
                //删除旧的
                Node toRemove = tail.before;
                map.put(toRemove.key, null);

                toRemove.before.after = tail;
                tail.before = toRemove.before;

                doInsert(key, value);
            }else{
                occupy ++;
                doInsert(key, value);
            }
        }else{
            //更新值
            node.data = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */