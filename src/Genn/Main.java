package Genn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomList<String> customList = new CustomList();
        String[] input = sc.nextLine().split(" ");
        while (!"END".equals(input[0])) {

            switch (input[0]) {
                case "Add":
                    String elementToAdd = input[1];
                    customList.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(input[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String element = input[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(input[1]);
                    int secondIndex = Integer.parseInt(input[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String e = input[1];
                    System.out.println(customList.greaterThan(e));
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
                case"Sort":
                    break;
                default:
                    System.out.println("Invalid command");
                    break;

            }
            input = sc.nextLine().split(" ");
        }
    }
}
