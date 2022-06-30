package OOP.workingWithAbstraction.Exe.CardsWithPowers;

import OOP.workingWithAbstraction.Exe.CardRank.CardRank;
import OOP.workingWithAbstraction.Exe.Suits.Suits;

public class Card {
    private CardRank rank;
    private Suits power;

    public Card(CardRank rank, Suits power) {
        this.rank = rank;
        this.power = power;
    }

    public int getSumPower() {
        return rank.getRank() + power.getPower();
    }

    public CardRank getRank() {
        return rank;
    }

    public void setRank(CardRank rank) {
        this.rank = rank;
    }

    public Suits getPower() {
        return power;
    }

    public void setPower(Suits power) {
        this.power = power;
    }
}
