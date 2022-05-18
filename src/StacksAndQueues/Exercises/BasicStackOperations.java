package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] params = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = params[0];
        int S = params[1];
        int X = params[2];

        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N ; i++) {
            stack.push(input[i]);
        }
        for (int i = 0; i <S ; i++) {
            stack.pop();
        }
        if(stack.contains(X)){
            System.out.println("true");
        }else if (stack.isEmpty()){
            System.out.println(0);
        }else{
            int current =Integer.MAX_VALUE;
            for (int i = 0; i < stack.size(); i++) {
                if(stack.peek()<current){
                    current=stack.peek();
                    stack.pop();
                }
            }
            System.out.println(current);
        }
    }
}
