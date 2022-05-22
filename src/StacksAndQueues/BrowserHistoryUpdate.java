package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayDeque<String> urls = new ArrayDeque<>();
        ArrayDeque<String> history = new ArrayDeque<>();
        while (!input.equals("Home")){
            if(!input.equals("back")&&!input.equals("forward")){
                System.out.println(input);
                urls.push(input);
            }if (input.equals("back")){
                if(urls.size()<=1){
                    System.out.println("no previous URLs");
                }else{
                    history.push(urls.pop());
                    System.out.println(urls.peek());
                }
            }
            if(input.equals("forward")){
                if(history.size()<1){
                    System.out.println("no next URLs");
                }else{
                    urls.push(history.peek());
                    System.out.println(history.pop());
                }
            }
            input = sc.nextLine();
    }
    }
}
