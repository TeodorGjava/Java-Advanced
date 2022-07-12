package OOP.InterfacesAndAbstraction.Exercises.Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> phoneNumbers = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        List<String> urls = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        Smartphone smartphone = new Smartphone(phoneNumbers,urls);
        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());

    }
}
