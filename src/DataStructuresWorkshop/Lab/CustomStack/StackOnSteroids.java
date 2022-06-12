package DataStructuresWorkshop.Lab.CustomStack;

import java.util.function.Consumer;

public class StackOnSteroids<E> {
    private static class Node<T> {

        private final T element;
        private final Node previous;

        public Node(T element, Node previous) {
            this.element = element;
            this.previous = previous;
        }
    }

    private Node top;
    private int size;

    public StackOnSteroids() {

    }

    public void push(E element) {
        this.top = new Node<>(element, this.top);
        this.size++;

    }
    private void isEmpty(){
        if(this.top == null){
            throw new IllegalStateException("Cannot execute on empty stack!");
        }
    }
    public int size(){
        return this.size;
    }
    public Object pop() {
        isEmpty();
        Object element = this.top.element;
        this.top = this.top.previous;
        this.size--;
        return element;
    }

    public Object peek() {
        isEmpty();
        return this.top.element;
    }

    public void forEach(Consumer<Object> consumer) {
        Node current = this.top;
        while (current != null){
            consumer.accept(current.element);
            current=current.previous;
        }
    }
}
