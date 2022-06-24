package Algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> input = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int x = Integer.parseInt(sc.nextLine());
        for (Integer i: input
             ) {
            if(i==x){
                System.out.print(input.indexOf(x));
            }
        }
    }
}
