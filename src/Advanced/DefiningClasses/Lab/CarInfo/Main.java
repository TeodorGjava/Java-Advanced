package Advanced.DefiningClasses.Lab.CarInfo;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Car car = new Car();
            String[] input = sc.nextLine().split(" ");
            car.setBrand(input[0]);
            car.setModel(input[1]);
            car.setHorsepower(Integer.parseInt(input[2]));
            System.out.println(car.carInfo());
        }
    }
}
