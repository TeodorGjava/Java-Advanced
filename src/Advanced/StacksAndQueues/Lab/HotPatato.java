package Advanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPatato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int rounds = Integer.parseInt(sc.nextLine());
        ArrayDeque<String> kids = new ArrayDeque<>();
        for (int i = 0; i <arr.length ; i++) {
            kids.offer(arr[i]);
        }
        int count = 1;
        while (kids.size()>1){
            String currentKid = kids.pop();
            if(count==rounds){
                System.out.println("Removed "+ currentKid);
                count=0;
            }else{
                kids.offer(currentKid);
            }
            count++;
        }
        System.out.println("Last is "+kids.peek());
    }
}
