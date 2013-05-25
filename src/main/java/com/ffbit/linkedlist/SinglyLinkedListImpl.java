package com.ffbit.linkedlist;

public class SinglyLinkedListImpl<E> implements SinglyLinkList<E> {
    private int size;
    private Link<E> head;

    private static class Link<E> {
        private E value;
        private Link<E> next;

        public Link(E value, Link<E> next) {
            this.value = value;
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Link<E> getNext() {
            return next;
        }

        public void setNext(Link<E> next) {
            this.next = next;
        }

        public boolean isValueEqualTo(E e) {
            return value.equals(e);
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
            if (current.isValueEqualTo(e)) {
                return true;
            }
        }

        return false;
    }

}
