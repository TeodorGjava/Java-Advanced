package DefiningClasses.Exc.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int enginesCount = Integer.parseInt(sc.nextLine());
        Map<String, Engine> engines = new LinkedHashMap<>();
        for (int i = 0; i < enginesCount; i++) {
            String[] engineInfo = sc.nextLine().split(" ");
            Engine engine = null;
            String type = engineInfo[0];
            String power = engineInfo[1];
            switch (engineInfo.length) {
                case 3:
                    if (engineInfo[2].length() > 1) {
                        String displacement = engineInfo[2];
                        engine = new Engine(type, power, Integer.parseInt(displacement));
                    } else {
                        String efficiency = engineInfo[2];
                        engine = new Engine(type, power, efficiency);
                    }
                    break;
                case 4:
                    engine = new Engine(type, power, engineInfo[2], engineInfo[3]);
                    break;
                default:
                    engine = new Engine(type, power);
            }
            engines.put(type, engine);
        }
        System.out.println();
        List<Car> cars = new ArrayList<>();
        int carsCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < carsCount; i++) {
            String[] carInfo = sc.nextLine().split(" ");
            String model = carInfo[0];
            String engineName = carInfo[1];
            Car car = null;
            Engine currentEngine = engines.get(engineName);
            switch (carInfo.length) {
                case 2:
                    car = new Car(model, currentEngine);
                    break;
                case 3:
                    if (Character.isDigit(carInfo[2].charAt(0))) {
                        car = new Car(model, currentEngine, carInfo[2]);
                    } else {
                        car = new Car(model, currentEngine, carInfo[2]);
                    }
                    break;
                case 4:
                    car = new Car(model, currentEngine, carInfo[2], carInfo[3]);
                    break;
            }
            cars.add(car);
        }

        cars.forEach(System.out::print);
    }
}
