package OOP.Inheritance.Exe.restaurant;

import java.math.BigDecimal;

public class Beverage extends Product{
    //•	name – String
    //•	price – BigDecimal
    //•	milliliters - double
    String name;
    BigDecimal price;
    double milliliters;

    public double getMilliliters() {
        return milliliters;
    }

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.name = name;
        this.price = price;
        this.milliliters = milliliters;
    }

}
