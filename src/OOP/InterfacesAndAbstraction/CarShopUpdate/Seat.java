package OOP.InterfacesAndAbstraction.CarShopUpdate;

public class Seat extends CarImpl implements Sellable{
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private double price;

    public Seat(String model, String color, int horsePower, String countryProduced, double price) {
        super(model,color,horsePower,countryProduced,price);

    }


    @Override
    public Double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return String.format("%s%n" +
                "%s Sells for %f", super.toString(), getModel(), getPrice());
    }
}
