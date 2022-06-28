package Advanced.SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<Integer> player1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> player2 = new LinkedHashSet<>();
        int[] firstCards = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondCards = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean hasEmpty = false;
        for (int card : firstCards
        ) {
            player1.add(card);
        }
        for (int card : secondCards
        ) {
            player2.add(card);
        }
        for (int i = 0; i < 50; i++) {
            if (player1.isEmpty()) {
                System.out.println("Second player win!");
                hasEmpty = true;
                break;
            }
            if (player2.isEmpty()) {
                hasEmpty = true;
                System.out.println("First player win!");
                break;
            }
            int firstPlayerCard = player1.iterator().next();
            player1.remove(firstPlayerCard);
            int secondPlayerCard = player2.iterator().next();
            player2.remove(secondPlayerCard);
            if (firstPlayerCard != secondPlayerCard) {
                if (firstPlayerCard > secondPlayerCard) {
                    player1.add(firstPlayerCard);
                    player1.add(secondPlayerCard);
                } else {
                    player2.add(firstPlayerCard);
                    player2.add(secondPlayerCard);
                }
            } else {
                player1.add(firstPlayerCard);
                player2.add(secondPlayerCard);
            }
        }
        if (!hasEmpty) {
            if (player1.size() > player2.size()) {
                System.out.println("First player win!");
            } else if (player1.size() < player2.size()) {
                System.out.println("Second player win!");
            } else {
                System.out.println("Draw!");
            }
        }
        //20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20
    }
}
