package solid.products;

public class Coke implements Product{

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;

    private final double milliliters;

    public Coke(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getAmountOfCalories() {
        return CALORIES_PER_100_GRAMS/100*this.getMilliliters()*DENSITY;
    }
}
