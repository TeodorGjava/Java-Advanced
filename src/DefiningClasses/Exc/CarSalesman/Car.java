package DefiningClasses.Exc.CarSalesman;

public class Car {
    //a model, engine, weight, and color.
    String model;
    Engine engine;
    int weight;
    String color;

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.weight= 0;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color="n/a";
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return this.model +
                "model='" + model + '\'' +
                ", engine=" + engine.model +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
