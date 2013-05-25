package com.ffbit.linkedlist;

import java.util.Iterator;

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

            current = current.getNext();
        }

        return false;
    }

    @Override
    public boolean remove(E e) {
        Link<E> previous = head;
        Link<E> current = previous;

        while (current != null) {
            if (current.isValueEqualTo(e)) {
                if (current == head) {
                    head = head.getNext();
                } else {
                    previous.setNext(current.getNext());
                }

                size--;

                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Link<E> head = SinglyLinkedListImpl.this.head;

            @Override
            public boolean hasNext() {
                return head != null;
            }

            @Override
            public E next() {
                E value = head.getValue();
                head = head.getNext();

                return value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not implemented.");
            }

        };
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
    }

}
