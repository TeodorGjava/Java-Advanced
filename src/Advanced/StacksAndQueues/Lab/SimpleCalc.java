package Advanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);
        while (stack.size()>1){
            int fnum= Integer.parseInt(stack.pop());
            String sign = stack.pop();
            int secnum = Integer.parseInt(stack.pop());
            int result = 0;
            if(sign.equals("+")){
                result = fnum+ secnum;
            }else{
                result = fnum-secnum;
            }
            stack.push(String.valueOf(result));
        }
        System.out.println(stack.peek());
    }
}
