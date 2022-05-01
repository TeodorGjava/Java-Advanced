package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPatato {
    static int i = 2;

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == i)
            return true;
        if (n % i == 0) {
            return false;
        }
        i++;
        return isPrime(n);
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
        int cycle = 1;
        boolean prime = false;
        while (kids.size() > 1) {
            String currentKid = kids.pop();
            if (count == rounds) {
                count = 0;
                if (!isPrime(cycle)) {
                    System.out.println("Removed " + currentKid);
                } else {
                    System.out.println("Prime " + currentKid);
                    prime=true;
                }
                if(prime){
                    kids.offer(currentKid);
                }
            }else{
                kids.offer(currentKid);
            }
            count++;
            cycle++;
        }
        System.out.println("Last is " + kids.peek());
    }
}
