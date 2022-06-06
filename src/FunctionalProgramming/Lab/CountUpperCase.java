package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Predicate<String> isUpper = s->
                Character.isUpperCase(s.charAt(0));
        List<String> text = Arrays.stream(sc.nextLine().split(" ")).filter(isUpper).collect(Collectors.toList());
        System.out.println(text.size());
        text.forEach(System.out::println);

    }
}
