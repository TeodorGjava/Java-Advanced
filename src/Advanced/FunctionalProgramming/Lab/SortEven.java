package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Predicate<Integer> isEven = e-> e%2==0;
        List<Integer> numbs = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(isEven)
                .collect(Collectors.toList());
        String collect = numbs.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.print(collect);
        numbs.sort(Integer::compareTo);
        collect = numbs.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(collect);
    }

}

