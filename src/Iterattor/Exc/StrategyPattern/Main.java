package Iterattor.Exc.StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        TreeSet<Person> byName = new TreeSet<>(new NameComparator());

        for (int i = 0; i < n; i++) {
            String[] peopleInfo = sc.nextLine().split(" ");
            String name = peopleInfo[0];
            int age = Integer.parseInt(peopleInfo[1]);
            Person person = new Person(name,age);
          //  byAge.add(person);
            byName.add(person);
        }

        for(Person person: byName){
            System.out.print(person);
        }
    }
}
