package OOP.Encapsulation.Exercises.Pizza;

public class Topping {
    //toppingType: String
//weight: double
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.toppingType = toppingType;
        this.weight = weight;
    }

    public double calculateCalories() {
        return 0;
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                break;
            default:
                String msg = String.format("Cannot place %s on top of your pizza.",toppingType);
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            String msg = String.format("%s weight shoud be in range [1..50].");
            throw new IllegalArgumentException(msg);
        }
        this.weight = weight;
    }
}
