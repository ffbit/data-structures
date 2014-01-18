package shad.stack;

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
        E element = top.value;
        top = top.next;

        return element;
    }

}
