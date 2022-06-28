package Advanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPatato {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split(" ");
        int nthToss = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> childsLeft = new ArrayDeque<>();
        Collections.addAll(childsLeft, kids);//
        int cycle = 1;
        while (childsLeft.size() > 1) {
            for (int i = 1; i < nthToss; i++)
                childsLeft.offer(childsLeft.poll());
            if (isPrime(cycle)) {
                System.out.println("Prime " + childsLeft.peek());
            } else {
                System.out.println("Removed " + childsLeft.poll());
            }

            cycle++;
        }
        System.out.println("Last is " + childsLeft.peek());
    }


    public static boolean isPrime(int n) {
        int i, m = 0;
        m = n / 2;
        if (n == 0 || n == 1) {
            return false;
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
