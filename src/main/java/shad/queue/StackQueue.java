package shad.queue;

import shad.stack.FixedStack;
import shad.stack.Stack;

public class StackQueue<E> implements Queue<E> {
    private Stack<E> input;
    private Stack<E> output;

    public StackQueue(int capacity) {
        input = new FixedStack<E>(capacity);
        output = new FixedStack<E>(capacity);
    }

    @Override
    public void enqueue(E element) {
        input.push(element);
    }

    @Override
    public E dequeue() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    @Override
    public int size() {
        return input.size() + output.size();
    }

}
