package DataStructuresWorkshop.Lab.CustomStack;

import java.util.function.Consumer;

public class StackOnSteroids {
    private static class Node {
        public Node(int element, Node previous) {
            this.element = element;
            this.previous = previous;
        }

        private int element;
        private Node previous;
    }

    private Node top;
    private int size;

    public StackOnSteroids() {

    }

    public void push(int element) {
        Node newNode = new Node(element, this.top);
        this.top = newNode;
        this.size++;

    }
    private void isEmpty(){
        if(this.top==null){
            throw new IllegalStateException("Cannot execute on empty stack!");
        }
    }
    public int size(){
        return this.size;
    }
    public int pop() {
        isEmpty();
        int element = this.top.element;
        this.top = this.top.previous;
        this.size--;
        return element;
    }

    public int peek() {
        isEmpty();
        return this.top.element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = this.top;
        while (current!=null){
            consumer.accept(current.element);
            current=current.previous;
        }
    }
}
