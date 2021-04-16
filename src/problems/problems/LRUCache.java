package problems.problems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    NodeEntry start =null;
    NodeEntry end = null;
    int size;
    private Map<Integer, NodeEntry> map;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            NodeEntry node = map.get(key);
            removeNode(node);
            addEntryToTop(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            NodeEntry node = map.get(key);
            node.val = value;
            removeNode(node);
            addEntryToTop(node);
        }
        else  {
            NodeEntry n = new NodeEntry(key, value);
            if ((map.size()>=size) ) {
                map.remove(end.key);
                removeNode(end);
            }
            addEntryToTop(n);
            map.put(key, n);

        }
    }

    private void removeNode(NodeEntry node) {
        if (node.left != null) {
            node.left.right = node.right;
        } else {
            start = node.right;
        }

        if (node.right !=null) {
            node.right.left = node.left;
        } else {
            end = node.left;
        }

    }

    private void addEntryToTop(NodeEntry node) {
        node.right = start;
        node.left = null;
        if (start != null) {
            start.left = node;
        }
        start = node;

        if (end == null) {
            end = start;
        }
    }

    public class NodeEntry {
        int val;
        int key;
        NodeEntry left;
        NodeEntry right;

        public NodeEntry(int key,int val) {
            this.val = val;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(2,1);
        lru.put(2,2);
        lru.get(2);
        lru.put(1,1);
        lru.put(4,1);
        lru.get(2);

    }

    public void printMap() {
        map.forEach((key, value) -> System.out.println(key + " : " + value.val));
    }


}
