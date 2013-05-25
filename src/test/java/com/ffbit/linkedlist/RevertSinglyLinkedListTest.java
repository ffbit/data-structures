package com.ffbit.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class RevertSinglyLinkedListTest {

    private Node<Integer> list;

    private class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> next) {
            this(value);
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            String output = String.valueOf(value);
            String separator = ", ";

            if (next == null) {
                return output;
            }

            return output + separator + next;
        }

    }

    @Before
    public void setUp() throws Exception {
        list = new Node<Integer>(1);
        list = new Node<Integer>(2, list);
        list = new Node<Integer>(3, list);
    }

    @Test
    public void itShouldComposeLinkedList() throws Exception {
        assertThat(list.toString(), containsString("3, 2, 1"));
    }

    @Test
    public void itShouldRevert() throws Exception {
        list = reverLinkedList(list);

        assertThat(list.toString(), containsString("1, 2, 3"));
    }

    private <E> Node<E> reverLinkedList(Node<E> list) {
        if (list == null) {
            return list;
        }

        Node<E> reverted = list;
        Node<E> tail = list.getNext();
        reverted.setNext(null);

        while (tail != null) {
            Node<E> buff = tail.getNext();
            tail.setNext(reverted);
            reverted = tail;
            tail = buff;
        }

        return reverted;
    }

}
