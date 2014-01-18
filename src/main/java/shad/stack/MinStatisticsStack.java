package shad.stack;

public class MinStatisticsStack<E extends Comparable<E>> {
    private int size;

    private ListStack<E> primaryStack;
    private ListStack<E> minStack;

    public MinStatisticsStack() {
        primaryStack = new ListStack<E>();
        minStack = new ListStack<E>();
    }

    public void push(E element) {
        pushMin(element);
        primaryStack.push(element);
        size++;
    }

    private void pushMin(E current) {
        E previous = current;

        if (size > 0) {
            previous = minStack.peek();
        }

        if (previous.compareTo(current) > 0) {
            minStack.push(current);
        } else {
            minStack.push(previous);
        }
    }

    public E min() {
        return minStack.peek();
    }

    public E pop() {
        minStack.pop();
        size--;

        return primaryStack.pop();
    }

}
