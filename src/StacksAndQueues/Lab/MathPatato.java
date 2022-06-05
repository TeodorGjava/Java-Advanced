package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPatato {


    public static boolean isPrime(int n) {
        int i,m=0;
        m=n/2;
        if(n==0||n==1){
            return false;
        }else{
            for(i=2;i<=m;i++){
                if(n%i==0){
                    return false;
                }
            }
        }return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int rounds = Integer.parseInt(sc.nextLine());
        ArrayDeque<String> kids = new ArrayDeque<>();
        for (String s : arr) {
            kids.offer(s);
        }
        int count = 1;
        int cycle = 0;
        while (kids.size()>1){
            String currentKid = kids.pop();
            if(isPrime(cycle)&& count==rounds){
                System.out.println("Prime "+ currentKid);
                kids.offer(currentKid);
                count=0;
            }else if(count==rounds&&!isPrime(cycle)){
                System.out.println("Removed "+ currentKid);
                count=0;
            }else{
                kids.offer(currentKid);
            }
            count++;
            cycle++;
        }
        System.out.println("Last is "+kids.peek());
}}
