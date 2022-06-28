package Advanced.SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] command = sc.nextLine().split(", ");
        LinkedHashSet<String> parking = new LinkedHashSet<>();
        int i = 0;
        while (!command[0].equals("END")) {
            String number = command[1];
            if (command[0].equals("IN")) {
                parking.add(number);
            } else {
                if (!parking.isEmpty()) {
                    parking.remove(number);
                } else {
                    System.out.println("Parking Lot is Empty");
                }
            }
            i++;
            command = sc.nextLine().split(", ");
        }
        if (!parking.isEmpty()) {
            for (String car : parking
            ) {
                System.out.println(car);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
