package StacksAndQueues.Lab;

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
        int count = 0;
        int cycle = 1;
      while (kids.size()>1){
              if(isPrime(cycle)&& count ==  rounds){
                  System.out.println("Prime "+ kids.peek());
                  count=0;
              }else if(count == rounds){
                  System.out.println("Removed "+ kids.poll());
                  count=0;
          }
          count++;
          cycle++;
          }
        System.out.println("Last is " + kids.peek());
}}
