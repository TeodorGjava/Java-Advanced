package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPatato {


    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <=n/2 ; i++) {
            if((n%i)==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int rounds = Integer.parseInt(sc.nextLine());
        ArrayDeque<String> kids = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            kids.offer(arr[i]);
        }
        int count = 1;
        int cycle = 0;
      while (kids.size()>1){
          String currentKid = kids.poll();
          if (cycle != 0) {
              if(isPrime(cycle)){
                  System.out.println("Prime "+ currentKid);
                  kids.offer(currentKid);
              }else{
                  System.out.println("Removed "+ currentKid);
              }
          }else{
              kids.offer(currentKid);
          }
          cycle++;
          }
        System.out.println("Last is " + kids.peek());
}}
