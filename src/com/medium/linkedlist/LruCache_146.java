package com.medium.linkedlist;

import java.util.HashMap;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/23 15:32
 * <p>
 * 146. LRU 缓存机制
 **/
public class LruCache_146 {
    class DLinkedNode {
        DLinkedNode prev;
        DLinkedNode next;
        int key;
        int value;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    // 双向链表使用伪头节点和伪尾节点，方便插入和删除
    private DLinkedNode head, tail;

    public LruCache_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 首先通过哈希表定位
        DLinkedNode node = cache.get(key);

        // 如果key不存在，则返回-1
        if (node == null) {
            return -1;
        }

        // 如果key存在，则将节点移动到双向链表头部，并返回节点值
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 首先通过哈希表定位
        DLinkedNode node = cache.get(key);

        // 如果key不存在
        if (node == null) {
            // 新建一个节点
            node = new DLinkedNode(key, value);
            // 将节点添加到双向链表头部
            addToHead(node);
            // 将节点添加到哈希表
            cache.put(key, node);
            size++;

            // 如果超出容量
            if (size > capacity) {
                // 删除双向链表的尾部节点
                int k = removeTail();
                // 删除哈希表中对应的项
                cache.remove(k);
                size--;
            }
        } else {
            // 如果key存在，修改value值，并将其移动到双向链表头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private int removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);

        return res.key;
    }
}
