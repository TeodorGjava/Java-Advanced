package Advanced.FunctionalProgramming.Exc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        //Min Functions
        //stream type
        Function<int[], Integer> streamFunction = arr-> Arrays.stream(arr).min().getAsInt();
        // method type
        Function<int[], Integer> smallest = (int[] arr) -> {
            int minValue = Integer.MAX_VALUE;
            for (int e : arr
            ) {
                if (e < minValue) {
                    minValue = e;
                }
            }
            return minValue;
        };
        System.out.println(smallest.apply(numbers));
    }
}
