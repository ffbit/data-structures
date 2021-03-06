package com.ffbit.bst;

public class BinarySearchTreeImpl<E extends Comparable<E>> implements BinarySearchTree<E> {
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

        @Override
        public String toString() {
            String output = "";
            final String separator = ", ";

            if (left != null) {
                output += left + separator;
            }

            output += value;

            if (right != null) {
                output += separator + right;
            }

            return output;
        }

    }

    public BinarySearchTreeImpl() {
        root = null;
        size = 0;
    }

    @Override
    public boolean add(E e) {
        if (add(new Node<E>(e), root)) {
            size++;
            return true;
        }

        return false;
    }

    private boolean add(Node<E> node, Node<E> parent) {
        Node<E> child = parent;
        boolean isLeft = false;

        while (child != null) {
            int comparison = node.getValue().compareTo(child.getValue());

            if (comparison == 0) {
                return false;
            }

            parent = child;

            if (comparison < 0) {
                child = parent.getLeft();
                isLeft = true;
            } else {
                child = parent.getRight();
                isLeft = false;
            }
        }

        if (size == 0) {
            root = node;
        } else if (isLeft) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }

        return true;
    }

    @Override
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

    @Override
    public boolean remove(E e) {
        Node<E> parent = root;
        Node<E> child = parent;
        boolean isLeft = false;

        while (child != null) {
            int comparison = e.compareTo(child.getValue());

            if (comparison == 0) {
                size--;
                Node<E> substitute = child.getRight();

                if (child == root) {
                    root = substitute;
                }

                Node<E> left = child.getLeft();

                if (left != null) {
                    add(left, substitute);
                }

                if (isLeft) {
                    parent.setLeft(substitute);
                } else {
                    parent.setRight(substitute);
                }

                return true;
            }

            parent = child;

            if (comparison < 0) {
                child = child.getLeft();
                isLeft = true;
            } else {
                child = child.getRight();
                isLeft = false;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public String toString() {
        String content = "";

        if (root != null) {
            content = root.toString();
        }

        return "BinarySearchTree [" + content + "]";
    }

}
