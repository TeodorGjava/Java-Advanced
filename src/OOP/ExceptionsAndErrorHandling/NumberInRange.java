package OOP.ExceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] bounds = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String number = sc.nextLine();

        System.out.printf("Range: [%s...%s]%n", bounds[0], bounds[1]);
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(number);
                isValid(n, bounds);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + number);
            }

        }


    }

    public static boolean isValid(int number, int[] bounds) {
        if (number >= bounds[0] && number <= bounds[1]) {
            System.out.println("Valid number: " + number);
            return true;
        } else {
            System.out.println("Invalid number " + number);
        }
        return false;
    }
}
