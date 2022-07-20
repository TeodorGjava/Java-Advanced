package OOP.Polymorphism.Exercises.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuel;
    private double litersPerKm;

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    public double getFuel() {
        return fuel;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    public Vehicle(double fuel, double litersPerKm) {
        this.fuel = fuel;
        this.litersPerKm = litersPerKm;
    }

    abstract void drive(double distance);
    abstract void refuel(double liters);
}
