package Algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(input);
        input.forEach(x-> System.out.print(x+ " "));
    }
}
