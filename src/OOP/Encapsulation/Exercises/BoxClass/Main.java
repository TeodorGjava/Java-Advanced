package OOP.Encapsulation.Exercises.BoxClass;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = Integer.parseInt(sc.nextLine());
        int w = Integer.parseInt(sc.nextLine());
        int h = Integer.parseInt(sc.nextLine());

        Box box = new Box(l,w,h);

        System.out.println(box.calculateSurfaceArea());
        System.out.println(box.calculateLateralSurfaceArea());
        System.out.println(box.calculateVolume());
    }
}
