package DataStructuresWorkshop.CustomStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackOnSteroids stackOnSteroids = new StackOnSteroids();

        stackOnSteroids.push(13);
        stackOnSteroids.push(18);
        stackOnSteroids.push(17);
        stackOnSteroids.push(15);
       stackOnSteroids.forEach(System.out::println);

    }
}
