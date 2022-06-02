package FunctionalProgramming.Exc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(sc.nextLine());
        list=  (list.stream().filter(x->x%n!=0).collect(Collectors.toList()));
        Collections.reverse(list);
        for (Integer integer : list) {
            System.out.print(integer+ " ");
        }
    }
}
