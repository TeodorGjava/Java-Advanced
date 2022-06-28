package Advanced.RegularExamJune2022;

import java.util.*;
import java.util.stream.Collectors;

public class Chocolate {
    static int chocolates = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Double> milk = Arrays.stream(sc.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        ArrayDeque<Double> powder = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(" "))
                .map(Double::parseDouble)
                .forEach(powder::push);

        Map<String, Integer> chocoMap = new TreeMap<>();

        while (!powder.isEmpty() && !milk.isEmpty()) {
            int milkIndex = 0;

            double milkValue = milk.get(milkIndex);
            double powderValue = powder.pop();

            double result = milkValue + powderValue;
            int percentage = (int) (powderValue / result * 100);

            switch ((int) percentage) {
                case 30:
                    if (!chocoMap.containsKey("Milk Chocolate")) {
                        chocoMap.put("Milk Chocolate", 1);
                    } else {
                        chocoMap.put("Milk Chocolate", chocoMap.get("Milk Chocolate") + 1);
                    }
                    chocolates++;
                    milk.remove(0);
                    break;
                case 50:
                    if (!chocoMap.containsKey("Dark Chocolate")) {
                        chocoMap.put("Dark Chocolate", 1);
                    } else {
                        chocoMap.put("Dark Chocolate", chocoMap.get("Dark Chocolate") + 1);
                    }
                    milk.remove(0);
                    chocolates++;
                    break;
                case 100:
                    if (!chocoMap.containsKey("Baking Chocolate")) {
                        chocoMap.put("Baking Chocolate", 1);
                    } else {
                        chocoMap.put("Baking Chocolate", chocoMap.get("Baking Chocolate") + 1);
                    }
                    milk.remove(0);
                    chocolates++;
                    break;
                default:
                    milk.remove(0);
                    milk.add(milkValue + 10);
            }
        }
        if (chocoMap.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            chocoMap.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            chocoMap.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));
        }
    }
}
