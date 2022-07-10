package OOP.Encapsulation.Exercises.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends ArrayList<Order>{
    private List<Order> orders;

    public ShoppingCart() {
        this.orders = new ArrayList<>();
    }

    public void addItem(Order order) {
        this.orders.add(order);
    }
}
