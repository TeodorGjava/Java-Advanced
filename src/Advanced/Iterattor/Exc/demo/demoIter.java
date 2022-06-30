package Advanced.Iterattor.Exc.demo;

import java.util.Iterator;
import java.util.List;

public class demoIter implements Iterable<String> {
    List<String> fruits;

    public demoIter(List<String> fruits) {
        this.fruits = fruits;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }
}
