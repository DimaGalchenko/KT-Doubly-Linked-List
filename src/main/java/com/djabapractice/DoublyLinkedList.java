package com.djabapractice;

public class DoublyLinkedList<K, V> {

    /**
     * Node represents a single entry in the cache, holding a key-value pair and
     * pointers to the previous and next nodes in the linked list.
     */
    public static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        private Node<K, V> prev;

        /**
         * Constructor to create a new node with a given key and value.
         *
         * @param key   the key of the node
         * @param value the value of the node
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        /**
         * Default constructor for creating head or tail dummy nodes.
         */
        public Node() {
            this(null, null);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public Node<K, V> getPrev() {
            return prev;
        }
    }

    private final Node<K, V> head;
    private final Node<K, V> tail;

    /**
     * Constructs an empty DoublyLinkedList with dummy head and tail nodes.
     */
    public DoublyLinkedList() {
        this.head = new Node<>(); // Dummy head
        this.tail = new Node<>(); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Removes a node from the linked list.
     *
     * @param node the node to be removed
     */
    public void removeNode(Node<K, V> node) {
        if (node == null || node == head || node == tail) {
            return; // Can't remove head or tail dummy nodes
        }

        Node<K, V> prevNode = node.prev;
        Node<K, V> nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        node.prev = null;
        node.next = null;
    }

    /**
     * Adds a node to the front of the linked list (right after the head).
     *
     * @param node the node to be added
     */
    public void addToFront(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    /**
     * Checks if the linked list is empty (i.e., only contains the dummy head and tail).
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head.next == tail;
    }

    /**
     * Removes and returns the last node in the list (right before the tail).
     *
     * @return the last node in the list, or null if the list is empty
     */
    public Node<K, V> removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node<K, V> lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    // Getter methods for head and tail for testing purposes
    public Node<K, V> getHead() {
        return head;
    }

    public Node<K, V> getTail() {
        return tail;
    }
}
