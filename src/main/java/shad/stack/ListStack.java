package shad.stack;

import java.util.NoSuchElementException;

public class ListStack<E> {
    private Node<E> top;

    private class Node<E> {
        E value;
        Node<E> next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(E element) {
        top = new Node<E>(element, top);
    }

    public E pop() {
        if (top == null) {
            throw new NoSuchElementException("Attempt to peek on empty stack");
        }

        E element = top.value;
        top = top.next;

        return element;
    }

    public E peek() {
        if (top == null) {
            throw new NoSuchElementException("Attempt to peek on empty stack");
        }

        return top.value;
    }

}
