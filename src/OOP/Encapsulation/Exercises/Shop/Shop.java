package OOP.Encapsulation.Exercises.Shop;

import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();
        String input = sc.nextLine();
        while (!"end".equals(input)){
            shoppingCart.add(Order.valueOf(input));
            input=sc.nextLine();
        }


        for (Order order :shoppingCart
             ) {
            System.out.println(order.toString()+" "+order.getPrice());
        }
        double sum = shoppingCart.stream().mapToDouble(Order::getPrice).sum();
        System.out.println(sum);
    }
}
