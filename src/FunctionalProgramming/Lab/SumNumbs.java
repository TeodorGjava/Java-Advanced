package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class SumNumbs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbs = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Count = "+ numbs.size());
        System.out.println("Sum = "+numbs.stream().mapToInt(e->e).sum());
        
    }
}
