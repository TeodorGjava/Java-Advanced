package DefiningClasses.Exc.SpeedRacing;

public class Cars {
    private String model;
    private double fuel;
    private double consumption;
    private int mileage = 0;

    public Cars(String model, double fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
    }
public boolean hasEnoughFuel(int distance){
        double fuelNeeded = distance*consumption;
        return fuel>=fuelNeeded;
}

    public void drive(String model, int distance) {
        double fuelNeeded = distance * consumption;
        if (fuelNeeded <fuel) {
            this.mileage += distance;
            this.fuel -= fuelNeeded;
        }else{
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
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
