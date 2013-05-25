package com.ffbit.linkedlist;

public class SinglyLinkedListImpl<E> implements SinglyLinkList<E> {
    private int size;
    private Link<E> head;

    private static class Link<E> {
        private E value;
        private Link<E> next;

        private Link(E value, Link<E> next) {
            this.value = value;
            this.next = next;
        }

        private E getValue() {
            return value;
        }

        private void setValue(E value) {
            this.value = value;
        }

        private Link<E> getNext() {
            return next;
        }

        private void setNext(Link<E> next) {
            this.next = next;
        }
    }

    public SinglyLinkedListImpl() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        head = new Link<E>(e, head);
        size++;
    }

    @Override
    public boolean contains(E e) {
        Link<E> current = head;

        while (current != null) {
            if (current.getValue().equals(e)) {
                return true;
            }
        }

        return false;
    }

}
