package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class matchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <input.length() ; i++) {
            if(input.charAt(i)=='('){
                stack.push(i);
            }else if(input.charAt(i)==')'){
                int start = stack.pop();
                String content = input.substring(start, i+1);
                System.out.println(content);
            }
        }
    }
}
