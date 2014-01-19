package shad.stack;

import java.util.NoSuchElementException;

public class ListStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    private class Node<E> {
        E value;
        Node<E> next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void push(E element) {
        top = new Node<E>(element, top);
        size++;
    }

    @Override
    public E pop() {
        if (top == null) {
            throw new NoSuchElementException("Attempt to peek on empty stack");
        }

        E element = top.value;
        top = top.next;
        size--;

        return element;
    }

    @Override
    public E peek() {
        if (top == null) {
            throw new NoSuchElementException("Attempt to peek on empty stack");
        }

        return top.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
