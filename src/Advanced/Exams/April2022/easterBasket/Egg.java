package Advanced.Exams.April2022.easterBasket;

import java.util.function.Consumer;

public class Egg {
    String color;
    int strength;
    String shape;

    public Egg(String color, int strength, String shape) {
        this.color = color;
        this.strength = strength;
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return String.format("%s egg, with %s strength and %s shape.",this.getColor(),this.getStrength(),this.getShape());
    }
}
