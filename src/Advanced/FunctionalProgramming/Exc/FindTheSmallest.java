package Advanced.FunctionalProgramming.Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FindTheSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>, Integer> func = integerList -> {
            int minElement = integerList.stream().mapToInt(e -> e).min().getAsInt();
            return integerList.lastIndexOf(minElement);
        };
        System.out.println(func.apply(list));
    }


    //method

    public static Integer minEIndex(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= min) {
                min = list.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }
}
