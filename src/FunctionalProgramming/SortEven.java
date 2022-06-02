package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbs = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numbs.removeIf(n -> n % 2 != 0);
        String collect = numbs.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(collect);
        numbs.sort(Integer::compareTo);
        collect = numbs.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(collect);
    }
}
