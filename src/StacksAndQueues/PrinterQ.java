package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String command = sc.nextLine();
        while (!command.equals("print")){
            if(command.equals("cancel")){
                if(queue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else{
                    String first = queue.poll();
                    System.out.printf("Canceled %s%n",first);
                }
            }else{
                queue.offer(command);
            }
            command = sc.nextLine();
        }
        int n = queue.size();
        for (int i = 0; i < n ; i++) {
            System.out.println(queue.pop());
        }
    }
}
