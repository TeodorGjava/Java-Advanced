package OOP.Polymorphism.Exercises.VehiclesExtend;

public class Bus extends AbstractVehicle {
    private static final double FUEL_CONSUMPTION_INCREASE = 1.4;
    private boolean empty;

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Bus(double fuel, double consumption, double capacity) {
        super(fuel, consumption, capacity);
    }

    @Override
    public String drive(double km) {
        if (empty) {
            return "Bus " + super.drive(km);
        }else{
            setConsumption(getConsumption()+FUEL_CONSUMPTION_INCREASE);
            String result = "Bus "+ super.drive(km);
            setConsumption(getConsumption()-FUEL_CONSUMPTION_INCREASE);
            return result;
        }
    }

    @Override
    public void print() {
        System.out.print("Bus");
        super.print();
    }
}
