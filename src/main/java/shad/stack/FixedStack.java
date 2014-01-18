package shad.stack;

public class FixedStack<E> {
    private final int capacity;
    private E[] holder;

    public FixedStack(int capacity) {
        this.capacity = capacity;
        holder = (E[]) new Object[capacity];
    }

    public int capacity() {
        return capacity;
    }

    public void push(E element) {
        holder[0] = element;
    }

    public E pop() {
        return holder[0];
    }

}
