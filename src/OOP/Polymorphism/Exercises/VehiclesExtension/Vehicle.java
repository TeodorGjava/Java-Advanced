package OOP.Polymorphism.Exercises.VehiclesExtension;

public abstract class Vehicle {
    private double fuel;
    private double litersPerKm;
    private int capacity;

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            System.out.println(("Fuel must be a positive number"));
            return;
        }
        this.capacity = capacity;
    }

    public void setFuel(double fuel) {
        if (this.getFuel() + fuel > capacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuel = fuel;
        }
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

    public Vehicle(double fuel, double litersPerKm, int capacity) {
        this.fuel = fuel;
        this.litersPerKm = litersPerKm;
        setCapacity(capacity);
    }

    abstract void drive(double distance);

    abstract void refuel(double liters);
}
