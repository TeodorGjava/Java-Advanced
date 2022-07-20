package OOP.Polymorphism.Exercises.VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] carTokens = sc.nextLine().split(" ");

            Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]), Integer.parseInt(carTokens[3]));

            String[] truckTokens = sc.nextLine().split(" ");
            Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]),Integer.parseInt(truckTokens[3]));

            String[] busTokens = sc.nextLine().split(" ");
            Vehicle bus = new Bus(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]),Integer.parseInt(truckTokens[3]));

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandParts = sc.nextLine().split(" ");

            String command = commandParts[0];
            String vehicle = commandParts[1];
            switch (command) {
                case "Drive":
                    switch (vehicle) {
                        case "Car":
                            car.drive(Double.parseDouble(commandParts[2]));
                            break;
                        case "Truck":
                            truck.drive(Double.parseDouble(commandParts[2]));
                            break;
                    }
                    break;
                case "Refuel":
                    switch (vehicle) {
                        case "Car":
                            car.refuel(Double.parseDouble(commandParts[2]));
                            break;
                        case "Truck":
                            truck.refuel(Double.parseDouble(commandParts[2]));
                            break;
                    }
                    break;
                case "DriveEmpty":

                    break;
            }

        }
        System.out.printf("Car: %.2f%n", car.getFuel());
        System.out.printf("Truck: %.2f%n", truck.getFuel());
    }
}
