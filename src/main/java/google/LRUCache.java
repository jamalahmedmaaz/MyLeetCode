package google;

import java.util.HashMap;

/**
 * Created by jamal on 31/1/18.
 */
public class LRUCache {

    private final int capacity;
    private DoublyLinkedList doublyLinkedList = null;
    private HashMap<Integer, Node> linkedListHashMap = new HashMap<Integer, Node>();


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);


       /* lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);

        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));*/
        System.out.println(lruCache.get(0));
    }

    LRUCache(int capacity) {
        doublyLinkedList = new DoublyLinkedList();
        this.capacity = capacity;
    }

    int get(int key) {
        if (doublyLinkedList.head != null && doublyLinkedList.head.key != key)
            if (linkedListHashMap.containsKey(key)) {
                Node node = linkedListHashMap.get(key);
                doublyLinkedList.remove(node);
                Node moveNode = doublyLinkedList.addToStart(key, node.getValue());
                linkedListHashMap.put(key, moveNode);
                return moveNode.getValue();
            } else
                return -1;
        return linkedListHashMap.containsKey(key) ? linkedListHashMap.get(key).getValue() : -1;
    }

    void put(int key, int value) {
        if (linkedListHashMap.containsKey(key)) {
            linkedListHashMap.get(key).setValue(value);
            get(key);
        } else {
            if (doublyLinkedList.size() + 1 > capacity) {
                doublyLinkedList.removeLast();
            }
            Node n = doublyLinkedList.addToStart(key, value);
            linkedListHashMap.put(key, n);
        }
    }

    public int getSize() {
        return capacity;
    }


    class DoublyLinkedList {
        private Node head;
        private Node tail;
        private int size;

        public int size() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Node addToStart(int key, int value) {
            Node node = new Node(key, value, head, null);

            if (head != null) head.previous = node;

            head = node;

            if (tail == null) tail = node;

            size++;

            return head;
        }


        public void removeLast() {
            linkedListHashMap.remove(tail.key);
            tail = tail.previous;
            if (tail != null)
                tail.next = null;
            size--;
        }

        public void remove(Node node) {
            if (getSize() == 1) {
                head = tail = null;
            } else {
                Node previous = node.previous;
                Node next = node.next;
                if (next != null) {
                    next.previous = previous;
                }
                if (previous != null) {
                    previous.next = next;
                }

                if (next == null) {
                    tail = previous;
                }
            }
            size--;

        }

    }

    class Node {
        private int key;
        private int value;
        private Node next;
        private Node previous;

        public int getKey() {
            return key;
        }

        public Node(int key, int value, Node head, Node tail) {
            this.value = value;
            this.key = key;
            this.next = head;
            this.previous = tail;

        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

}
