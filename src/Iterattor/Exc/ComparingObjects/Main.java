package Iterattor.Exc.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("END")) {
            String[] peopleInfo = input.split(" ");
            String name = peopleInfo[0];
            int age = Integer.parseInt(peopleInfo[1]);
            String town = peopleInfo[2];
            Person person = new Person(name, age, town);
            people.add(person);
            input = sc.nextLine();
        }
        int comparePersonIndex = Integer.parseInt(sc.nextLine());
        Person personToComp = people.get(comparePersonIndex - 1);

        int totalPeople = people.size();
        int samePeople = 0;
        int differentPeople = 0;
        for (Person person : people) {
            if(person.compareTo(personToComp)==0){
                samePeople++;
            }else{
                differentPeople++;
            }
        }
        if(samePeople==1){
            System.out.println("No matches");
        }else{
            System.out.printf("%d %d %d",samePeople,differentPeople,people.size());
        }
        System.out.println();
    }
}
