package OOP.workingWithAbstraction.Lab.Hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(line[0]);
        int days = Integer.parseInt(line[1]);
        Season season = Season.parse(line[2]);

        Discount discount = Discount.parse(line[3]);
        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay,days,season,discount);
        System.out.printf("%.2f%n",priceCalculator.calculatePrice());
    }
}
