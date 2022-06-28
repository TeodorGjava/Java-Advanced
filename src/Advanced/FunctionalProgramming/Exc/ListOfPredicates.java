package Advanced.FunctionalProgramming.Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> listOfNumbersToDivide = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Predicate<Integer> isDivisible = num -> {
            for (Integer numToDivide : listOfNumbersToDivide
            ) {
                if (num % numToDivide != 0) {
                    return false;
                }
            }
            return true;
        };
        for (int i = 1; i <= n; i++) {
            if (isDivisible.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
