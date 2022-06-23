package Exams.August2021;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // read input : first line is queue and second is stack
        ArrayDeque<Integer> liquids = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<String, Integer> cookedThings = new LinkedHashMap<>();

        cookedThings.put("Biscuit", 0);
        cookedThings.put("Cake", 0);
        cookedThings.put("Pie", 0);
        cookedThings.put("Pastry", 0);

        while (!ingredients.isEmpty() && !liquids.isEmpty()) {
            int lastIngredient = ingredients.poll();
            int sum = liquids.pop() + lastIngredient;
            String cookedFood = null;
            switch (sum) {
                case 25:
                    cookedFood = "Biscuit";
                    cookedThings.replace("Biscuit", cookedThings.get("Biscuit") + 1);
                    break;
                case 50:
                    cookedFood = "Cake";
                    cookedThings.replace("Cake", cookedThings.get("Cake") + 1);
                    break;
                case 75:
                    cookedFood = "Pastry";
                    cookedThings.replace("Pastry", cookedThings.get("Pastry") + 1);
                    break;

                case 100:
                    cookedFood = "Pie";
                    cookedThings.replace("Pie", cookedThings.get("Pie") + 1);
                    break;
                default:
                    cookedFood = null;

            }
            if (cookedFood != null) {
            } else {
                ingredients.push(lastIngredient + 3);

            }
        }
        boolean allFoodsAreCooked = cookedThings.entrySet().stream().allMatch(e -> e.getValue() > 0);
        if (allFoodsAreCooked) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        String remainingLiqyids = liquids.isEmpty() ? "none" : liquids.stream()
                .map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Liquids left: " + remainingLiqyids);

        String remainingIngredients = ingredients.isEmpty() ? "none" : ingredients.stream()
                .map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("Ingredients left: " + remainingIngredients);

        cookedThings.forEach((key, value) -> System.out.println(key + ": " + value));


    }
}
