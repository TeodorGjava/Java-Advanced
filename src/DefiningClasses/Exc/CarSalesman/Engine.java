package DefiningClasses.Exc.CarSalesman;

public class Engine {
    //model, power, displacement, and efficiency
    String model;
    String power;
    String displacement = "n/a";
    String efficiency;

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
        this.displacement="n/a";
        this.efficiency = "n/a";

    }

    public Engine(String model, String power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = String.valueOf(displacement);
        this.efficiency= "n/a";
    }

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
    public Engine(String model, String power,String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
        this.displacement="n/a";
    }
}
