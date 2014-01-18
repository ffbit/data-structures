package shad.stack;

import java.util.NoSuchElementException;

public class FixedStack<E> {
    private E[] holder;
    int top;

    @SuppressWarnings("unchecked")
    public FixedStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Fixed stack capacity must be a positive natural number, but was <" + capacity + ">");
        }

        holder = (E[]) new Object[capacity];
    }

    public int capacity() {
        return holder.length;
    }

    public void push(E element) {
        if (size() == holder.length) {
            throw new NoSuchElementException("Attempt to push in full stack");
        }

        holder[top++] = element;
    }

    public E pop() {
        if (size() == 0) {
            throw new NoSuchElementException("Attempt to pop from empty stack");
        }

        return holder[--top];
    }

    public int size() {
        return top;
    }

    public E peek() {
        if (size() == 0) {
            throw new NoSuchElementException("Attempt to peek from empty stack");
        }

        return holder[top - 1];
    }

}
