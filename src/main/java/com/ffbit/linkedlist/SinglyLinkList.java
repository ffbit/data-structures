package com.ffbit.linkedlist;

public interface SinglyLinkList<E> extends Iterable<E> {

    int size();

    void add(E e);

    boolean contains(E e);

    boolean remove(E e);

    void clear();

}
