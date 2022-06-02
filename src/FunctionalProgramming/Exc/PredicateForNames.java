package FunctionalProgramming.Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Predicate<String> predicate = s -> s.length() <= n;
        List<String> list = Arrays.stream(sc.nextLine().split(" ")).filter(predicate).collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
