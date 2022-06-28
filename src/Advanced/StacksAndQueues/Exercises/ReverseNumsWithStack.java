package Advanced.StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumsWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int n:arr
             ) {
            stack.push(n);
        }
        for (int n:stack){
            System.out.print(stack.pop()+" ");
        }
    }
}
