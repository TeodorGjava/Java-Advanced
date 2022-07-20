package OOP.Polymorphism.Exercises.VehiclesExtension;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final double CONSUMPTION = 0.9;
    private DecimalFormat df = new DecimalFormat("#.##");

    public Car(double fuel, double litersPerKm,int capacity) {
       super(fuel,litersPerKm+CONSUMPTION,capacity);
    }

    @Override
    void drive(double distance) {
        if((this.getLitersPerKm()+CONSUMPTION)*distance<this.getFuel()){
            System.out.printf("Car travelled %s km%n",df.format(distance));
            double fuel =this.getFuel()-(this.getLitersPerKm())*distance;
            this.setFuel(fuel);
        }else{
            System.out.println("Car needs refueling");
        }
    }

    @Override
    void refuel(double liters) {
        this.setFuel(this.getFuel()+liters);
    }
}
