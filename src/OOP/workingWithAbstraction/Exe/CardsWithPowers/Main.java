package OOP.workingWithAbstraction.Exe.CardsWithPowers;

import OOP.workingWithAbstraction.Exe.CardRank.CardRank;
import OOP.workingWithAbstraction.Exe.Suits.Suits;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CardRank cardRank = CardRank.valueOf(sc.nextLine());
        Suits suits = Suits.valueOf(sc.nextLine());
        Card card = new Card(cardRank,suits);
        System.out.printf("Card name: %s of %s; Card power: %d",cardRank,suits,card.getSumPower());
    }
}
