package DefiningClasses.Exc.CarSalesman;

public class Car {
    //a model, engine, weight, and color.
    String model;
    Engine engine;
    String weight;
    String color;

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.weight = "n/a";
    }

    public Car(Engine engine, String model, String weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                        "%s:%n" +
                        "Power: %s%n" +
                        "Displacement: %s%n" +
                        "Efficiency: %s%n" +
                        "Weight: %s%n" +
                        "Color: %s%n", this.model, this.engine.model, this.engine.power, this.engine.displacement,
                this.engine.efficiency, this.weight, this.color);
    }
}
