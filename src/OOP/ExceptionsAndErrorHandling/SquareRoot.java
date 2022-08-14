package OOP.ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        try {
            double sqrt = Math.sqrt(Integer.parseInt(console.nextLine()));
            if (sqrt > 0) System.out.printf("%.2f%n", sqrt);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid");

        } finally {
            System.out.println("Goodbye");
        }
    }
}

