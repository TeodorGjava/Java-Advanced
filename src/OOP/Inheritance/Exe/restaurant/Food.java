package OOP.Inheritance.Exe.restaurant;

import java.math.BigDecimal;

public class Food extends Product{
    //•	name – String
    //•	price – double
    //•	grams - double
    String name;
    double price;
    double grams;

    public double getGrams() {
        return grams;
    }

    public Food(String name, BigDecimal price, String name1, double price1, double grams) {
        super(name, price);
        this.name = name1;
        this.price = price1;
        this.grams = grams;
    }

    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams=grams;
    }
}
