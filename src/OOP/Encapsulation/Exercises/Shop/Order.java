package OOP.Encapsulation.Exercises.Shop;

public enum Order {
    PRODUCT1(2.50),PRODUCT2(5.70),PRODUCT3(4.70),PRODUCT4(5.00),PRODUCT5(5.99);
    private double price;
    Order(double price){
        this.price=price;
    }

    public double getPrice() {
        return price;
    }
}
