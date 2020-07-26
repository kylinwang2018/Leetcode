import java.util.HashMap;
import java.util.Map;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity * / );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */

public class Q146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1); // returns 1
        cache.put(3, 3); // evicts key 2
        cache.get(2); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        cache.get(1); // returns -1 (not found)
        cache.get(3); // returns 3
        cache.get(4); // returns 4
    }
}

class LRUCache {

    class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, ListNode> map;
    ListNode head, tail;
    int availableCapacity;

    public LRUCache(int capacity) {
        this.availableCapacity = capacity;
        map = new HashMap<Integer, ListNode>();
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null)
            return -1;
        // 3 conditions,
        // node is head, tail, or neither.
        if (node != tail) {
            if (node == head) {
                head = head.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            // move node to the tail
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }

        return node.val;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
            // need to add a new node
            ListNode newNode = new ListNode(key, value);

            if (availableCapacity == 0) {
                map.remove(head.key);
                head = head.next;
                availableCapacity++;
            }

            // add to the list
            if (head == null) {
                // very first node
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
            }

            tail = newNode;
            availableCapacity--;
            map.put(key, newNode);
        } else {
            // found exisiting node
            node.val = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }

                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }
        }
    }
}
