package DefiningClasses.Exc.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Person> people = new ArrayList<>();
        while(n-->0) {
            String[] line = sc.nextLine().split(" ");
            String name = line[0];
            int age = Integer.parseInt(line[1]);
            Person person = new Person(name, age);
            people.add(person);
        }
        people.stream().filter(x -> x.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
