package catHouse.repositories;

import catHouse.entities.toys.Toy;

import java.util.*;

public class ToyRepository implements Repository {

    private List<Toy> toys;

    

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        boolean contains = toys.contains(toy);
        toys.remove(toy);
        return contains;
    }

    @Override
    public Toy findFirst(String type) {

        return toys
                .stream()
                .filter(t->t.getClass().getSimpleName().equals(type))
                .findFirst()
                .orElse(null);
    }
}
