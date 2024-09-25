package com.djabapractice;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer, String> list;
    private DoublyLinkedList.Node<Integer, String> node1;
    private DoublyLinkedList.Node<Integer, String> node2;
    private DoublyLinkedList.Node<Integer, String> node3;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
        node1 = new DoublyLinkedList.Node<>(1, "A");
        node2 = new DoublyLinkedList.Node<>(2, "B");
        node3 = new DoublyLinkedList.Node<>(3, "C");
    }

    @Test
    public void testIsEmpty_whenListIsEmpty_shouldReturnTrue() {
        assertTrue(list.isEmpty(), "List should be empty when initialized.");
    }

    @Test
    public void testIsEmpty_whenListIsNotEmpty_shouldReturnFalse() {
        list.addToFront(node1);
        assertFalse(list.isEmpty(), "List should not be empty after adding a node.");
    }

    @Test
    public void testAddToFront_singleNode_shouldAddNodeToFront() {
        list.addToFront(node1);
        assertSame(node1, list.getHead().getNext(), "Node1 should be the first element after head.");
        assertSame(list.getTail(), node1.getNext(), "Node1 should point to tail.");
    }

    @Test
    public void testAddToFront_multipleNodes_shouldAddNodesToFront() {
        list.addToFront(node1);
        list.addToFront(node2);

        assertSame(node2, list.getHead().getNext(), "Node2 should be the first element after head.");
        assertSame(node1, node2.getNext(), "Node2 should point to Node1.");
        assertSame(list.getTail(), node1.getNext(), "Node1 should point to tail.");
    }

    @Test
    public void testRemoveNode_singleNode_shouldRemoveCorrectly() {
        list.addToFront(node1);
        list.removeNode(node1);
        assertTrue(list.isEmpty(), "List should be empty after removing the only node.");
    }

    @Test
    public void testRemoveNode_multipleNodes_shouldRemoveCorrectly() {
        list.addToFront(node1);
        list.addToFront(node2);
        list.removeNode(node1);

        assertSame(list.getTail(), node2.getNext(), "After removing Node1, Node2 should point to tail.");
    }

    @Test
    public void testRemoveLast_singleNode_shouldReturnLastNode() {
        list.addToFront(node1);
        DoublyLinkedList.Node<Integer, String> removed = list.removeLast();

        assertSame(node1, removed, "removeLast() should return the only node.");
        assertTrue(list.isEmpty(), "List should be empty after removing the only node.");
    }

    @Test
    public void testRemoveLast_multipleNodes_shouldReturnCorrectLastNode() {
        list.addToFront(node1);
        list.addToFront(node2);
        DoublyLinkedList.Node<Integer, String> removed = list.removeLast();

        assertSame(node1, removed, "removeLast() should return the last node.");
        assertSame(list.getTail(), node2.getNext(), "After removing Node1, Node2 should point to tail.");
    }

    @Test
    public void testRemoveLast_whenListIsEmpty_shouldReturnNull() {
        DoublyLinkedList.Node<Integer, String> removed = list.removeLast();
        assertNull(removed, "removeLast() should return null when list is empty.");
    }

    @Test
    public void testAddDummyHeadAndTailNodes_shouldHaveCorrectLinks() {
        assertSame(list.getTail(), list.getHead().getNext(), "Head should initially point to tail.");
        assertSame(list.getHead(), list.getTail().getPrev(), "Tail should initially point to head.");
    }
}
