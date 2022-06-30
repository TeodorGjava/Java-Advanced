package OOP.workingWithAbstraction.Exe.Suits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(input+":");
        System.out.printf("Ordinal value: %d; Name value: %s%n", Suits.CLUBS.ordinal(),Suits.CLUBS);
        System.out.printf("Ordinal value: %d; Name value: %s%n",Suits.DIAMONDS.ordinal(),Suits.DIAMONDS);
        System.out.printf("Ordinal value: %d; Name value: %s%n",Suits.HEARTS.ordinal(),Suits.HEARTS);
        System.out.printf("Ordinal value: %d; Name value: %s%n",Suits.SPADES.ordinal(),Suits.SPADES);
    }
}
