package OOP.InterfacesAndAbstraction.Lab.Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String driver = sc.nextLine();
        Ferrari ferrari = new Ferrari(driver);
        System.out.println(ferrari);
    }
}
