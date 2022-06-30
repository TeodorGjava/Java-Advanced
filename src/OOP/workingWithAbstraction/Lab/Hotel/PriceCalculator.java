package OOP.workingWithAbstraction.Lab.Hotel;

public class PriceCalculator {

    private double pricePerDay;
    private int days;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int number, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.days = number;
        this.season = season;
        this.discount = discount;
    }

    public double calculatePrice() {
        return pricePerDay * days * season.getMultiplier() * discount.getPriceReduction();
    }
}
