package OOP.Inheritance.Exe.hierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        while (!type.equals("Beast!")) {
            String[] data = sc.nextLine().split(" ");
            try {
                switch (type) {
                    case "Cat":
                        Cat cat = new Cat(data[0], Integer.parseInt(data[1]), data[2]);
                        System.out.print(cat);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(data[0], Integer.parseInt(data[1]));
                        System.out.print(tomcat);
                        break;
                    case"Kitten":
                        Kitten kitten = new Kitten(data[0], Integer.parseInt(data[1]));
                        System.out.print(kitten);
                    case "Dog":
                        Dog dog = new Dog(data[0], Integer.parseInt(data[1]), data[2]);
                        System.out.print(dog);
                        break;
                    case "Frog":
                        Frog frog = new Frog(data[0], Integer.parseInt(data[1]), data[2]);
                        System.out.print(frog);
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            type = sc.nextLine();
        }
    }
}
