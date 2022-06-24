package Genn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public T remove(int index) {
        return values.remove(index);
    }

    public boolean contains(T element) {
        return values.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(values, firstIndex, secondIndex);
    }

    public long greaterThan(T element) {
        return values.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMin() {
        return values.stream().min(Comparable::compareTo).get();
    }

    public T getMax() {
        return values.stream().max(Comparable::compareTo).get();
    }



    public int size(){
        return values.size();
    }
    public T get(int index){
        return values.get(index);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T val : values
        ) {
            str.append(String.format("%s%n", val.toString()));
        }
        return str.toString().trim();
    }
}
