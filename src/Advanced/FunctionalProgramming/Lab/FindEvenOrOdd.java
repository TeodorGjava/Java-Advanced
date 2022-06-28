package Advanced.FunctionalProgramming.Lab;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvenOrOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        List<Integer> numbersList = new LinkedList<>();
        Predicate<Integer> isEven = e -> e % 2 == 0;
        Predicate<Integer> isOdd = e -> e % 2 != 0;
        for (int i = a; i <= b; i++) {
            numbersList.add(i);
        }
        String type = sc.nextLine();
        if (!numbersList.isEmpty())
            if (type.equals("even")) {
                numbersList.stream().filter(isEven).forEach(x -> System.out.print(x + " "));
            } else if (type.equals("odd")) {
                numbersList.stream().filter(isOdd).forEach(x -> System.out.print(x + " "));
            }
    }
}
