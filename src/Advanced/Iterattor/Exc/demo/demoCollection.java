package Advanced.Iterattor.Exc.demo;

import java.util.ArrayList;
import java.util.List;

public class demoCollection {
    List<String> collection;

    public demoCollection(String... args) {
        this.collection = new ArrayList<>();
    }

    public int size() {
        return collection.size();
    }
}
