package Advanced.Exams.April2022.easterBasket;

import java.util.*;
import java.util.function.Consumer;

public class Basket implements Iterable<Egg> {
    List<Egg> data;
    String material;
    int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : data
        ) {
            if (egg.getColor().equals(color)) {
                data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        Egg strongest = null;
        int bestStrength = 0;
        for (Egg egg : data) {
            if (egg.getStrength() > bestStrength) {
                strongest = egg;
            }
        }
        return strongest;
    }

    public Egg getEgg(String color) {
        for (Egg egg : data
        ) {
            if (egg.getColor().equals(color)) {
                return egg;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String report() {

        String a = this.material + " contains:\n";
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <data.size() ; i++) {
            s.append(data.get(i).toString()+"\n");
        }
        return a + s;

    }

    public String forEach() {
        for (Egg egg : data) {
            return egg.toString()+"%n";
        }
        return null;
    }

    @Override
    public Iterator<Egg> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index<data.size();
            }

            @Override
            public Egg next() {
                return data.get(index);
            }

        };
    }

    @Override
    public void forEach(Consumer<? super Egg> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Egg> spliterator() {
        return Iterable.super.spliterator();
    }
}
