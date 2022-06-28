package Advanced.Algorithms.Factorial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(fact(n));
    }

    public static long fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
}
