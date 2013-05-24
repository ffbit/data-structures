package com.ffbit.bst;

public class BinarySearchTree<E> {
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(E e) {
        size++;
    }

    public void clear() {
        size = 0;
    }

}
