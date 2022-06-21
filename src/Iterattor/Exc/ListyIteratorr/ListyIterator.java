package Iterattor.Exc.ListyIteratorr;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.*;

public class ListyIterator implements Iterable<String> {
    private final List<String> elements;
    private int currentIndex;


    public boolean hasNext() {
        return currentIndex < elements.size();
    }

    public boolean move() {
        if (hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public ListyIterator(String... elements) {

        this.elements = List.of(elements);
    }

    public void print() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid operation");
        } else {
            System.out.println(this.elements.get(currentIndex));
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index< elements.size();
            }

            @Override
            public String next() {
                return elements.get(index);
            }
        };
    }
}
