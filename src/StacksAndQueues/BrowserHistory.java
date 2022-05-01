package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayDeque<String> urls = new ArrayDeque<>();
        while (!input.equals("Home")){
            if(!input.equals("back")){
                System.out.println(input);
                urls.push(input);
            }else{
                if(urls.size()<=1){
                    System.out.println("no previous URLs");
                }else{
                    urls.pop();
                    System.out.println(urls.peek());
                }
            }
                input = sc.nextLine();
        }
    }
}
