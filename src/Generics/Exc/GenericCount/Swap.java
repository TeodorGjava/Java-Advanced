package Generics.Exc.GenericCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Swap<T extends Comparable<T>> {
    List<T> values;

    public Swap() {
        this.values = new ArrayList<>();
    }
    public void add(T element){
        values.add(element);
    }
    public void swap(int index1,int index2){
        //T temp = values.get(index1);
        //values.set(index1, values.get(index2));
        //values.set(index2,temp);
        //   or
        Collections.swap(values,index1,index2);
    }
    public long countGraterItems(T element){
        //extends comparable to have compareTo method
        return values.stream().filter(itemFromBox -> itemFromBox.compareTo(element)>0).count();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T e: values
             ) {
            str.append(String.format("%s: %s%n",e.getClass().getName(),e));
        }
        return str.toString();
    }
}
