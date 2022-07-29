package OOP.Polymorphism.Exercises.Farm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private final String livingRegion;
    private final DecimalFormat df = new DecimalFormat("#.##");

    public DecimalFormat getDf() {
        return df;
    }

    @Override
    void makeSound() {

    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                getAnimalType(),
                getAnimalName(),
                df.format(getAnimalWeight()),
                livingRegion,
                getFoodEaten());
    }

    @Override
    void eat(Food food) {

    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }
}
