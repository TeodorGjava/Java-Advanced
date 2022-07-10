package OOP.InterfacesAndAbstraction.Lab.CarShopUpdate;

public class CarImpl implements Car{
    private static final int TIRE = 4;
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Double price;

    public CarImpl(String model, String color, Integer horsePower, String countryProduced, Double price) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return countryProduced;
    }


    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %s tires",model,countryProduced,TIRE);
    }
}
