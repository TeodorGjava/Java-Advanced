package OOP.workingWithAbstraction.Exe.CardRank;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(input + ":");
        Arrays.stream
                        (CardRank.values())
                .forEach(x -> System.out.printf("Ordinal value: %d; Name value: %s%n", x.ordinal(), x.name()));

    }
}
