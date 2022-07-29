package OOP.Polymorphism.Exercises.VehiclesExtend;

import java.text.DecimalFormat;

public class AbstractVehicle implements Vehicle {
    private double fuel;
    private double consumption;
    private double capacity;
    private DecimalFormat df = new DecimalFormat("#.##");

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public AbstractVehicle(double fuel, double consumption, double capacity) {
        setFuel(fuel);
        setConsumption(consumption);
        setCapacity(capacity);
    }

    @Override
    public String drive(double km) {
        if (!hasFuel(km)) {
            return "needs refueling";
        }
        setFuel(getFuel()-km*consumption);
        return "travelled " + df.format(km) + " km";
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
        if (fuel + liters > getCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            fuel += liters;
        }
    }

    @Override
    public void print() {
        System.out.println(": " + String.format("%.2f", fuel));
    }

    public double getFuel() {
        return fuel;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getCapacity() {
        return capacity;
    }

    protected boolean hasFuel(double km) {
        double fuelSpend = km * getConsumption();
        return fuelSpend < getFuel();
    }
}
