package OOP.InterfacesAndAbstraction.CarShopUpdate;

public class Audi extends CarImpl implements Rentable {
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Integer minRentDay;
    private Double price;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double price) {
        super(model, color, horsePower, countryProduced, price);
        this.minRentDay = minRentDay;
    }


    @Override
    public String toString() {
        return String.format("%s%n" +
                "%s Sells for %f", super.toString(), getModel(), getPrice());
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return getPricePerDay();
    }
}
