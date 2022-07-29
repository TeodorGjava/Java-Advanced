package solid.products;

public class Chocolate implements Product {

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    private final double grams;

    public Chocolate(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return this.grams;
    }

    @Override
    public double getAmountOfCalories() {
        return CALORIES_PER_100_GRAMS/100*this.grams;
    }
}
