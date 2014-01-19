package shad.stack;

public class VersionedStack<E> {
    private E value;
    private VersionedStack<E> next;

    public VersionedStack() {
    }

    private VersionedStack(E value, VersionedStack<E> next) {
        this.value = value;
        this.next = next;
    }

    public VersionedStack<E> push(E element) {
        return new VersionedStack<E>(element, this);
    }

    public VersionedStack<E> pop() {
        return next;
    }

    public E peek() {
        return value;
    }

}
