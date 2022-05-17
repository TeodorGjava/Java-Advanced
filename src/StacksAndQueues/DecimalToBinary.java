package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int input = Integer.parseInt(sc.nextLine());
        if(input!=0){
        while (input!=0){
            stack.push(input%2);
            input/=2;
        }
        int n = stack.size();
        for (int i = 0; i <n ; i++) {
            System.out.print(stack.pop());
        }
    }else{
            System.out.println(0);
        }}
}
