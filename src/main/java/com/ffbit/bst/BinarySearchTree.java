package com.ffbit.bst;

public class BinarySearchTree<E extends Comparable<E>> {
    private int size = 0;
    private Node<E> root;

    private static class Node<E extends Comparable<E>> {
        private E value;
        private Node<E> left;
        private Node<E> right;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public boolean add(E e) {
            if (value.compareTo(e) == 0) {
                return false;
            }

            return true;
        }
    }

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(E e) {
        if (size == 0) {
            root = new Node<E>(e);
            size++;
            return true;
        } else if (root.add(e)) {
            size++;
            return true;
        }

        return false;
    }

    public void clear() {
        size = 0;
    }

}
