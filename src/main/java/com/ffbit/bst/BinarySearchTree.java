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

    }

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(E e) {
        Node<E> parent = root;
        Node<E> child = parent;
        boolean isLeft = false;

        while (child != null) {
            int comparison = e.compareTo(child.getValue());

            if (comparison == 0) {
                return false;
            }

            parent = child;

            if (comparison < 0) {
                child = parent.getLeft();
                isLeft = true;
            } else {
                child = parent.getRight();
            }
        }

        child = new Node<E>(e);

        if (size == 0) {
            root = child;
        } else if (isLeft) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }

        size++;

        return true;
    }

    public void clear() {
        size = 0;
    }

    public boolean contains(E e) {
        Node<E> current = root;

        while (current != null) {
            int comparison = e.compareTo(current.getValue());

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        return false;
    }

}
