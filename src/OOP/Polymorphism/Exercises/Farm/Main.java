package OOP.Polymorphism.Exercises.Farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Animal> animalList = new ArrayList<>();
        List<Food> foodList = new ArrayList<>();

        String input = sc.nextLine();
        while (!"End".equals(input)) {
            String[] animalTokens = input.split("\\s+");
            if ("Cat".equals(animalTokens[0])) {
                Animal cat = new Cat(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3], animalTokens[4]);
                animalList.add(cat);
            } else if ("Mouse".equals(animalTokens[0])) {
                Animal mouse = new Mouse(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                animalList.add(mouse);
            } else if ("Tiger".equals(animalTokens[0])) {
                Animal tiger = new Tiger(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                animalList.add(tiger);
            } else if ("Zebra".equals(animalTokens[0])) {
                Animal zebra = new Zebra(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                animalList.add(zebra);
            }

            String[] foodTokens = input.split("\\s+");
            if ("Vegetable".equals(foodTokens[0])) {
                Food vegetable = new Vegetable(Integer.parseInt(foodTokens[1]));
                foodList.add(vegetable);
            } else if ("Meat".equals(foodTokens[0])) {
                Food meat = new Meat(Integer.parseInt(foodTokens[1]));
                foodList.add(meat);
            }

            input = sc.nextLine();
        }

        for (int i = 0; i < animalList.size(); i++) {
            Animal animal = animalList.get(i);
            Food food = foodList.get(i);

            animal.makeSound();
            animal.eat(food);
        }

        for (Animal animal : animalList) {
            System.out.println(animal);
        }
    }
}
