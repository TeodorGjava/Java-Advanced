package OOP.Encapsulation.Exercises.Pizza;

public class Topping {
    //toppingType: String
//weight: double
    private double modifier;
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }


    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
                modifier = 1.2;
                break;
            case "Veggies":
                modifier = 0.8;
                break;
            case "Cheese":
                modifier = 1.1;
                break;
            case "Sauce":
                modifier=0.9;
                break;
            default:
                String msg = String.format("Cannot place %s on top of your pizza.", toppingType);
                throw new IllegalArgumentException(msg);
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
    public double calculateCalories(){
        return weight*2*modifier;
    }
}
