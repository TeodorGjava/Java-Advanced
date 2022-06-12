package Generics;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = List.of(1000,464,723,9);
        System.out.println(ListUtils.getMin(numbers));
        System.out.println(ListUtils.getMax(numbers));
    }
}
