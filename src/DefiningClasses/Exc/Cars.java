package DefiningClasses.Exc;

public class Cars {
    private String model;
    private int fuel;
    private double consumption;
    private int mileage = 0;

    public Cars(String model, int fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
    }

    public void drive(Cars car,int distance){

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    //Model, fuel amount, fuel cost for 1 kilometer, and distance traveled.
    // A Car Model is unique - there will never be 2 cars with the same model.

}
