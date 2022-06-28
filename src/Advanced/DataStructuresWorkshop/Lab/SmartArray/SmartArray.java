package Advanced.DataStructuresWorkshop.Lab.SmartArray;

import java.util.function.Consumer;

public class SmartArray {
    private Integer[] elements;
    private int size = 0;

    public SmartArray() {
        this.elements = new Integer[4];
    }

    // a method to delete element by index
    public int remove(int index) {
        checkIndex(index);
        //first element, index 0
        int element = this.elements[index];
        this.size--;
        if (this.size - index >= 0) System.arraycopy(this.elements, index + 1, this.elements, index, this.size - index);
        this.elements[this.size] = 0;

        //middle index
        if (this.elements.length / 2 >= this.size && this.elements.length > 4) {
            this.elements = shrink();
        }
        //last index
        return element;
    }


    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            Integer e = this.elements[i];
            consumer.accept(e);
        }
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {

        checkIndex(index);
        int lastElement = this.elements[this.size - 1];
        if (this.size - 1 - index >= 0) {
            System.arraycopy(this.elements, index, this.elements, index + 1, this.size - 1 - index);
        }
        this.elements[index] = element;
        add(lastElement);
    }

    private Integer[] shrink() {
        Integer[] newData = new Integer[this.elements.length / 2];
        return newData;
    }

    public void add(int element) {
        //if index is out of bounds
        if (this.size == this.elements.length) {
            this.elements = expand();
        }
        elements[size] = element;
        size++;
    }

    //get method by index
    public int get(int index) {
        checkIndex(index);
        return this.elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Shiban index " + index);
        }
    }

    //.size() method for an array
    public int size() {
        return this.size;
    }

    //recreating the array in new Array with +1 size
    //allocating new memory for the new +1 element Arr
    private Integer[] expand() {
        Integer[] newArray = new Integer[this.elements.length * 2];
        //transferring the elements to the new Arr
        for (int i = 0; i < this.elements.length; i++) {
            newArray[i] = this.elements[i];
        }
        return newArray;
    }
}
