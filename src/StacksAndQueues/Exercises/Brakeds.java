package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Brakeds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayDeque<Character> openingBr = new ArrayDeque<>();
        for (int i = 0; i <input.length()/2 ; i++) {
            openingBr.offer(input.charAt(i));
        }
        ArrayDeque<Character> closingBr = new ArrayDeque<>();
        for (int i = input.length()-1; i >=input.length()/2 ; i--) {
            closingBr.offer(input.charAt(i));
        }

        if(comp(openingBr,closingBr)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    public static boolean comp(ArrayDeque<Character> q1, ArrayDeque<Character> q2){
        String a = q1.toString();
        String b = q2.toString();

        return a.equals(b);
    }
}
