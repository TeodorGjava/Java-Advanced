package solid.products;

public class Lemonade implements Product{

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    private final double milliliters;

    public Lemonade(double milliliters) {
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
