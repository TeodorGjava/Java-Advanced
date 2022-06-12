package DataStructuresWorkshop.Lab.CustomStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackOnSteroids stackOnSteroids = new StackOnSteroids();
        StackOnSteroids stackOnSteroids2 = new StackOnSteroids();
stackOnSteroids2.push("Hello");
stackOnSteroids2.push("Hi there");
stackOnSteroids2.push("Hello again");

        stackOnSteroids.push(13);
        stackOnSteroids.push(18);
        stackOnSteroids.push(17);
        stackOnSteroids.push(15);
       stackOnSteroids.forEach(System.out::println);
       stackOnSteroids2.forEach(System.out::println);

    }
}
