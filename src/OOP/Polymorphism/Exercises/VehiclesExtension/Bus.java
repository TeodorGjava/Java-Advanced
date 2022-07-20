package OOP.Polymorphism.Exercises.VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private static final double CONSUMPTION = 1.6;
    private static boolean isEmpty = true;
    private DecimalFormat df = new DecimalFormat("#.##");

    public Bus(double fuel, double litersPerKm, int capacity) {
        super(fuel, litersPerKm, capacity);
    }

    @Override
    void drive(double distance) {
        if (!isEmpty && (this.getLitersPerKm() + CONSUMPTION) * distance < this.getFuel()) {
            System.out.printf("Truck travelled %s km%n", df.format(distance));
            double fuel = this.getFuel() - this.getLitersPerKm() * distance;
            this.setFuel(fuel);
        }
    }

    @Override
    void refuel(double liters) {

    }
}
