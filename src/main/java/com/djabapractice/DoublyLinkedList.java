package com.djabapractice;

public class DoublyLinkedList<K, V> {

    /**
     * Node represents a single entry in the cache, holding a key-value pair and
     * pointers to the previous and next nodes in the linked list.
     */
    public static class Node<K, V> {

        /**
         * Constructor to create a new node with a given key and value.
         *
         * @param key   the key of the node
         * @param value the value of the node
         */
        public Node(K key, V value) {

        }

        /**
         * Default constructor for creating head or tail dummy nodes.
         */
        public Node() {

        }

        // Getter methods for key and value (for testing and usage)
        public K getKey() {
            throw new RuntimeException("Not implemented");
        }

        public V getValue() {
            throw new RuntimeException("Not implemented");
        }

        public Node<K, V> getNext() {
            throw new RuntimeException("Not implemented");
        }

        public Node<K, V> getPrev() {
            throw new RuntimeException("Not implemented");
        }
    }


    /**
     * Constructs an empty DoublyLinkedList with dummy head and tail nodes.
     */
    public DoublyLinkedList() {

    }

    /**
     * Removes a node from the linked list.
     *
     * @param node the node to be removed
     */
    public void removeNode(Node<K, V> node) {

    }

    /**
     * Adds a node to the front of the linked list (right after the head).
     *
     * @param node the node to be added
     */
    public void addToFront(Node<K, V> node) {

    }

    /**
     * Checks if the linked list is empty (i.e., only contains the dummy head and tail).
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Removes and returns the last node in the list (right before the tail).
     *
     * @return the last node in the list, or null if the list is empty
     */
    public Node<K, V> removeLast() {
        throw new RuntimeException("Not implemented");
    }

    // Getter methods for head and tail for testing purposes
    public Node<K, V> getHead() {
        throw new RuntimeException("Not implemented");
    }

    public Node<K, V> getTail() {
        throw new RuntimeException("Not implemented");
    }
}
