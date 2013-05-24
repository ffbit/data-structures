package com.ffbit.bst;

public interface BinarySearchTree<E extends Comparable<E>> {

    boolean add(E e);

    boolean contains(E e);

    boolean remove(E e);

    int size();

    void clear();

}
