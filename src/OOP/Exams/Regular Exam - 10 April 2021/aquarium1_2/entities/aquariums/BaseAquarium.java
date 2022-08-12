package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.*;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;



    public BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
    public boolean isFull(){
        return fish.size()-capacity>0;
    }
    @Override
    public int calculateComfort() {
        return fish.stream().mapToInt(f -> (int) f.getPrice()).sum();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish f) {
        if (!isFull()) {
            fish.add(f);
            capacity--;
        } else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeFish(Fish f) {
        this.fish.remove(f);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {

        fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("%s (%s):%n", name, this.getClass().getSimpleName()
        ));
        str.append("Fish: ");
        str.append(fish.isEmpty() ? "none" : fish.stream().map(Fish::getName));
        str.append(System.lineSeparator());
        str.append("Decorations: ").append(decorations.size());
        str.append(System.lineSeparator());
str.append("Comfort : ").append(decorations.stream().mapToInt(Decoration::getComfort).sum());
        str.append(System.lineSeparator());
        return str.toString().trim();

    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
