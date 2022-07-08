package OOP.Encapsulation.Exercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] inputPeople = sc.nextLine().split(";");

        for (String personInfo : inputPeople
        ) {
            String[] parts = personInfo.split("=");

            String name = parts[0];
            double money = Double.parseDouble(parts[1]);
            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String[] productInput = sc.nextLine().split(";");
        for (String productInfo:productInput
             ) {
            String[] parts = productInfo.split("=");
                String name = parts[0];
                double cost = Double.parseDouble(parts[1]);

                try{
                    Product product = new Product(name,cost);
                    products.put(name,product);
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    return;
                }
        }
        String command = sc.nextLine();
        while (!"END".equals(command)){
            String[] part = command.split(" ");
            String personName = part[0];
            String productName = part[1];

            Person buyer = people.get(personName);

            Product wantedProduct = products.get(productName);

            try {
                buyer.buyProduct(wantedProduct);
                System.out.printf("%s bought %s%n",personName,wantedProduct);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            command=sc.nextLine();
        }
        people.values().forEach(System.out::println);
        }
    }
