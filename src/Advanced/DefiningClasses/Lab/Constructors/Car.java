package Advanced.DefiningClasses.Lab.Constructors;

public class Car {
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHp() {
        return hp;
    }

    String brand;
    String model;
    int hp;

    public Car(String brand) {
        this.brand = brand;
        this.model="unknown";
        this.hp =-1;
    }

    public Car(String brand, String model, int hp) {
        this.brand = brand;
        this.model = model;
        this.hp = hp;
    }
    public String carInfo(){
        return String.format("The car is: %s %s - %d HP.",this.getBrand(),this.getModel(),this.getHp());
    }
}
