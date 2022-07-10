package OOP.Inheritance.Exe.Nfs;

public class Vehicle {
    //•	DEFAULT_FUEL_CONSUMPTION – final static double (constant)
    final static double DEFAULT_FUEL_CONSUMPTION = 1.25;
    double fuelConsumption;
    double fuel;
    int horsePower;

    public void drive(double kilometers) {
        double fuelNeeded = kilometers*fuelConsumption;
        if(fuel>=fuelNeeded){
            fuel-=fuelNeeded;
        }
    }

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
