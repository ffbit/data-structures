package com.ffbit.linkedlist;

public class SinglyLinkedListImpl<E> implements SinglyLinkList<E> {
    private int size;

    public SinglyLinkedListImpl() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        size++;
    }

}
