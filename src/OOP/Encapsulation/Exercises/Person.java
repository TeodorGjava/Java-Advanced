package OOP.Encapsulation.Exercises;

import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private List<Product> products;

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s cant afford %s", name, product.getName()));
        }
        products.add(product);
        money = money - product.getCost();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        String productsList = products.stream().map(Product::getName).collect(Collectors.joining(", "));

        if(productsList.isEmpty()){
            str.append("Nothing bought");
        }else{
        str.append(productsList);
        }
        return str.toString();
    }
}
