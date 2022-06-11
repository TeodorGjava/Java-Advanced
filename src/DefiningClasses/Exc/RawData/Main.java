package DefiningClasses.Exc.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            String model = line[0];
            int engineSpeed = Integer.parseInt(line[1]);
            int enginePower = Integer.parseInt(line[2]);
            Engine engine = new Engine(engineSpeed,enginePower);
            int cargoWeight = Integer.parseInt(line[3]);
            String cargoType = line[4];
            Cargo cargo = new Cargo(cargoWeight,cargoType);

            List<Tire> tires = new ArrayList<>();
            for (int j = 5; j < line.length; j+=2) {
                Tire tire = new Tire(Double.parseDouble(line[j]),Integer.parseInt(line[j+1]));
            tires.add(tire);
            }
            Car car = new Car(model,engine,cargo,tires);
            cars.add(car);
        }
        String command = sc.nextLine();
        if(command.equals("fragile")){
            cars.stream().filter(car -> car.getCargo().getType().equals("fragile")).filter(car -> car.getTires()
                    .stream().anyMatch(tire -> tire.getPressure()<1)).forEach(x-> System.out.println(x.getModel()));
        }else{
cars.stream().filter(car ->car.getCargo().getType().equals("flamable"))
        .filter(car->car.getEngine().getPower()>250).forEach(car -> System.out.println(car.getModel()));
        }
    }
}
