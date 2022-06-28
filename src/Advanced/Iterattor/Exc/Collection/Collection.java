package Advanced.Iterattor.Exc.Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Collection implements Iterable<String> {
    private List<String> elements;
    private int currentIndex;


    public boolean hasNext() {
        return currentIndex < elements.size()-1;
    }

    public boolean move() {
        if (hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public Collection(String... elements) {

        this.elements = Arrays.asList(elements);
        this.currentIndex=0;
    }

    public void print() {
        if (this.elements.isEmpty()) {
            System.out.println("Invalid Operation!");
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
    public void printAll(){
        for(String s: elements){
            System.out.printf("%s ",s);
        }
        System.out.println();
    }
}
