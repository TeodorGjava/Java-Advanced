package OOP.Polymorphism.Exercises.VehiclesExtend;

public class Car extends AbstractVehicle{
    private static final double FUEL_CONSUMPTION_INCREASE = 0.9;
    public Car(double fuel, double consumption, double capacity) {
        super(fuel, consumption+FUEL_CONSUMPTION_INCREASE, capacity);
    }

    @Override
    public String drive(double km) {
        return "Car "+ super.drive(km);
    }

    @Override
    public void print() {
        System.out.print("Car");
        super.print();
    }

}
