package OOP.InterfacesAndAbstraction.Exercises.FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            String[] infoParts = input.split(" ");

            Person person = infoParts.length == 3 ? new Rebel(infoParts[0], Integer.parseInt(infoParts[1]), infoParts[2])
                    : new Citizen(infoParts[0],Integer.parseInt(infoParts[1]), infoParts[2], infoParts[3]);
            people.add(person);
        }
        String buyer = sc.nextLine();
        while (!buyer.equals("End")){
            for (Person p: people
                 ) {
                if(p.getName().equals(buyer)){
                    p.buyFood();
                }
            }
            buyer = sc.nextLine();
        }
        int sum = 0;
        for (Person person : people
        ) {
            sum += person.getFood();
        }
        System.out.println(sum);
    }
}
