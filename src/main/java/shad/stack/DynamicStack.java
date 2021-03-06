package shad.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DynamicStack<E> implements Stack<E> {
    private E[] holder;
    private int top;

    @SuppressWarnings("unchecked")
    public DynamicStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException(
                    "Dynamic stack initial capacity must be a positive natural number, " +
                            "but was <" + initialCapacity + ">");
        }

        holder = (E[]) new Object[initialCapacity];
    }

    public DynamicStack() {
        this(16);
    }

    public int capacity() {
        return holder.length;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public void push(E element) {
        if (size() == capacity()) {
            holder = Arrays.copyOf(holder, size() * 2);
        }

        holder[top++] = element;
    }

    @Override
    public E pop() {
        if (size() == 0) {
            throw new NoSuchElementException("Attempt to pop on empty stack");
        }

        E element = holder[--top];

        if (capacity() / Math.max(size(), 1) >= 4) {
            holder = Arrays.copyOf(holder, capacity() / 2);
        }

        return element;
    }

    @Override
    public E peek() {
        if (size() == 0) {
            throw new NoSuchElementException("Attempt to peek on empty stack");
        }

        return holder[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
