package DefiningClasses.Exc.CarSalesman;

public class Engine {
    //model, power, displacement, and efficiency
    String model;
    String power;
    int displacement;
    String efficiency;

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, String power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
    }

    public Engine(String model, String power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
    public Engine(String model, String power,String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
    }
}
