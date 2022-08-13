package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.*;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public abstract class BaseHouse implements House {
    //	name - String
    private String name;

    //	All names are unique.
    //	capacity -  int
    private int capacity;
    //	The number of Cat аn House can have.
    private Map<String, Toy> toys;
    private List<Cat> cats;
    //	toys - Collection<Toy>
    //	cats - Collection<Cat

    protected BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new LinkedHashMap<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return toys.values().stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (cats.size() == capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat.getName());
    }

    @Override
    public void buyToy(Toy toy) {
        toys.put(toy.getClass().getSimpleName(), toy);
    }

    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        if (cats.isEmpty()) {
            sb.append("none");
        } else {
            for (Cat cat : cats
            ) {
                sb.append(cat.getName())
                        .append(" ");
            }
        }

        return String.format("%s %s:%n" +
                                "Cats: %s%n" +
                                "Toys: %s Softness: %d", this.getName(), this.getClass().getSimpleName(),
                        sb.toString().trim(), toys.size(), this.sumSoftness());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys.values();
    }
}
