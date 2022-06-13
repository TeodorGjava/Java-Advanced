package Generics.Exc.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class GenericBox<T>{
    private List<T> values;

    public GenericBox() {
        this.values=new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T value: values
             ) {
            str.append(String.format("%s: %s%n",value.getClass().getName(),value));
        }
                return str.toString();
    }
}
