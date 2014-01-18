package shad.stack;

public class FixedStack<E> {
    private E[] holder;
    int top;

    public FixedStack(int capacity) {
        holder = (E[]) new Object[capacity];
    }

    public int capacity() {
        return holder.length;
    }

    public void push(E element) {
        holder[top++] = element;
    }

    public E pop() {
        return holder[--top];
    }

    public int size() {
        return top;
    }

}
