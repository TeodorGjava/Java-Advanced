package Advanced.Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] firstBox = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> first = new ArrayDeque<>();
        for (int x : firstBox
        ) {
            first.offer(x);
        }
        ArrayDeque<Integer> second = new ArrayDeque<>();
        int[] secondBox = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int x : secondBox
        ) {
            second.push(x);
        }
        int totalfirst = 0;
        int totalsecond = 0;
        int totalSum = 0;
        while (!first.isEmpty() && !second.isEmpty()) {
            int a = first.peek();
            int b = second.peek();
            int sum = a + b;
            if (sum % 2 == 0) {
                totalSum+=sum;
                first.poll();
                second.pop();
            } else {
                first.offer(second.pop());
            }
        }
        if (first.isEmpty()) {
            System.out.println("First magic box is empty.");

        } else {
            System.out.println("Second magic box is empty.");
        }
        if (totalSum < 90) {
            System.out.println("Poor prey... Value: " + totalSum);
        } else {
            System.out.println("Wow, your prey was epic! Value: " + totalSum);
        }

    }
}
