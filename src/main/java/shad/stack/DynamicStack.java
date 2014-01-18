package shad.stack;

import java.util.Arrays;

public class DynamicStack<E> {
    private E[] holder;
    private int top;

    @SuppressWarnings("unchecked")
    public DynamicStack(int initialCapacity) {
        holder = (E[]) new Object[initialCapacity];
    }

    public DynamicStack() {
        this(16);
    }

    public int capacity() {
        return holder.length;
    }

    public int size() {
        return top;
    }

    public void push(E element) {
        if (size() == capacity()) {
            holder = Arrays.copyOf(holder, size() * 2);
        }

        holder[top++] = element;
    }

    public E pop() {
        E element = holder[--top];

        if (capacity() / Math.max(size(), 1) >= 4) {
            holder = Arrays.copyOf(holder, capacity() / 2);
        }

        return element;
    }

    public E peek() {
        return holder[top - 1];
    }

}
