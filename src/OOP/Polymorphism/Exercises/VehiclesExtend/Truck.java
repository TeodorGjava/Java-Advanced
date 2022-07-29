package OOP.Polymorphism.Exercises.VehiclesExtend;

public class Truck extends AbstractVehicle{
    private static final double FUEL_CONSUMPTION_INCREASE = 1.6;
    public Truck(double fuel, double consumption, double capacity) {
        super(fuel, consumption+FUEL_CONSUMPTION_INCREASE, capacity);

    }

    @Override
    public String drive(double km) {
        return"Truck "+ super.drive(km);
    }

    @Override
    public void print() {
        System.out.print("Truck");
        super.print();
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters*0.95);
    }
}
