package Advanced.StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Fibonacci {
    private static long[] memory;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        memory=new long[n+1];
        if(n==0){
            System.out.println(0);
            return;
        }
       long result = fib(n);
        System.out.println(result);
    }

    private static long fib(int n) {
        if (n <= 1) {
            return 1l;
        }
        if(memory[n]!=0){
            return memory[n];
        }
        memory[n]= fib(n-1)+fib(n-2);
        return memory[n];
    }
}
