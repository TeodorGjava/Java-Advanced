package DefiningClasses.Exc.Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Person> personMap = new LinkedHashMap<>();
        String command = sc.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split(" ");
            String name = tokens[0];
            String clazz = tokens[1];
            personMap.putIfAbsent(name, new Person());
            switch (clazz) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    personMap.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(name).addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parents parents = new Parents(parentName, parentBirthday);
                    personMap.get(name).addParents(parents);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirth = tokens[3];
                    Children child = new Children(childName, childBirth);
                    personMap.get(name).addChildren(child);
                    break;
                case "car":
                    String model = tokens[2];
                    String speed = tokens[3];
                    Car car = new Car(model,speed);
                    personMap.get(name).setCar(car);
                    break;
            }
            command = sc.nextLine();
        }
        String person = sc.nextLine();
        System.out.println(person);
        System.out.println("Company:");
        Person value = personMap.get(person);
        if(value.getCompany()!=null){
            System.out.println(value.getCompany().getCompanyName()+" "+value.getCompany().getDepartment()+" "+value.getCompany().getSalary());
        }
        System.out.println("Car:");
        if(value.getCar()!=null){
            System.out.printf("%s %s%n",value.getCar().getModel(),value.getCar().getSpeed());
        }
        System.out.println("Pokemon:");
        if(!value.getPokemon().isEmpty()){
            value.getPokemon().forEach(x-> System.out.print(x.getPokemonName()+" "+ x.getPokemonType()+"\n"));
        }
        System.out.println("Parents:");
        if(!value.getParents().isEmpty()){
            value.getParents().forEach(x-> System.out.print(x.getParent()+" "+ x.getParentBirthday()+"\n"));
        }
        System.out.println("Children:");
        if(!value.getChildren().isEmpty()){
            value.getChildren().forEach(x-> System.out.print(x.getChildName()+" "+ x.getChildBirthday()+"\n"));
        }

    }
}
