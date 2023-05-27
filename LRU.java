import java.util.*;

class LRUCache {

    class DLinkNode{
        int value;
        int key;
        DLinkNode prev;
        DLinkNode next;
    }

    private void addNode (DLinkNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node; 
    }

    private void removeNode (DLinkNode node){
        DLinkNode prev = node.prev;
        DLinkNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private DLinkNode popTail (){
        DLinkNode oldTail = tail.prev;
        DLinkNode newTail = tail.prev.prev;

        newTail.next = tail;
        tail.prev = newTail;

        return oldTail;
    }

    private void moveToHead (DLinkNode node){
        removeNode(node);
        addNode(node);
        // DLinkNode prev = node.prev;
        // DLinkNode next = node.next;

        // prev.next = next;
        // next.prev = prev;

        // DLinkNode oldHead = head.next;
        // head.next = node;
        // oldHead.prev = node;
        // node.prev = head;
        // node.next = oldHead;
    }



    private DLinkNode head, tail;
    private HashMap<Integer, DLinkNode> cache = new HashMap<>();
    private int capacity;
    private int size;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        else {
            moveToHead(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null){
            node = new DLinkNode();
            node.key = key;
            node.value = value;
            addNode(node);
            cache.put(key, node);
            size ++;
            if (size > capacity){
                DLinkNode oldTail = popTail();
                cache.remove(oldTail.key);
                size --; 
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */