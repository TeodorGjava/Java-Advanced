package solid.products;

public class Chips implements Product{
    public static final double CALORIES_PER_100_GRAMS = 529.0;
    private final double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return this.grams;
    }

    @Override
    public double getAmountOfCalories() {
        return CALORIES_PER_100_GRAMS/100*this.getGrams();
    }
}
