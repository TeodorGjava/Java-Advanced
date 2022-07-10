package OOP.Encapsulation.Exercises.Pizza;

import java.util.Scanner;

public class Main {
    static double cals = 0;

    public static void main(String[] args) {

        //•	On the first line is the pizza name and the number of toppings it has in the format:
        //Pizza {pizzaName} {numberOfToppings}
        Scanner sc = new Scanner(System.in);
        String[] pizzaData = sc.nextLine().split(" ");
        String pizzaName = pizzaData[1];
        int numOfToppings = Integer.parseInt(pizzaData[2]);
        if (numOfToppings > 10) {
            System.out.println("Number of toppings should be in range [0..10].");
            return;
        }
        String[] doughData = sc.nextLine().split(" ");
        //Dough Wholegrain Crispy 100
        String doughType = doughData[1];
        String bakingTechnique = doughData[2];
        int weight = Integer.parseInt(doughData[3]);

        try {
            Dough dough = new Dough(doughType, bakingTechnique, weight);
            Pizza pizza = new Pizza(pizzaName, numOfToppings);
            String[] toppings = sc.nextLine().split(" ");
            cals += dough.calculateCalories();
            while (!toppings[0].equals("END")) {

                String toppingType = toppings[1];
                int toppingWeight = Integer.parseInt(toppings[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
                toppings = sc.nextLine().split(" ");
                cals += topping.calculateCalories();
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.printf("%s - %.2f",pizzaName,cals);
    }
}
