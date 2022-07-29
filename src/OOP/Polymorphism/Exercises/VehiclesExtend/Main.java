package OOP.Polymorphism.Exercises.VehiclesExtend;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String[] carTokens = sc.nextLine().split("\\s+");
            Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]),
                    Double.parseDouble(carTokens[3]));

            String[] truckTokens = sc.nextLine().split("\\s+");
            Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]),
                    Double.parseDouble(truckTokens[3]));

            String[] busTokens = sc.nextLine().split("\\s+");
            Vehicle bus = new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]),
                    Double.parseDouble(busTokens[3]));

            Map<String, Vehicle> vehicleMap = new HashMap<>();
            vehicleMap.put("Car", car);
            vehicleMap.put("Truck", truck);
            vehicleMap.put("Bus", bus);

            int commandCount = Integer.parseInt(sc.nextLine().trim());

            for (int i = 0; i < commandCount; i++) {
                String[] commandTokens = sc.nextLine().split("\\s+");
                double quantity = Double.parseDouble(commandTokens[2]);
                Vehicle currentVehicle = vehicleMap.get(commandTokens[1]);

                if ("Drive".equals(commandTokens[0])) {
                    System.out.println(currentVehicle.drive(quantity));
                } else if ("Refuel".equals(commandTokens[0])) {
                    currentVehicle.refuel(quantity);
                } else if ("DriveEmpty".equals(commandTokens[0])) {
                    Bus currentBus = ((Bus)bus);
                    currentBus.setEmpty(true);
                    System.out.println(currentBus.drive(quantity));
                    currentBus.setEmpty(false);
                }
            }

            car.print();
            truck.print();
            bus.print();
    }
}
