package Advanced.StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            switch (arr[0]) {
                case 1:
                    int num = arr[1];
                    stack.push(num);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(stack.stream().max(Integer::compare).get());
                        break;
                    }
            }
        }
    }

