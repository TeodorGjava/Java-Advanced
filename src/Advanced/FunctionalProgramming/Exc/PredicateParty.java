package Advanced.FunctionalProgramming.Exc;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> people = Arrays.stream(sc.nextLine().split(" "))
                .collect(Collectors.toList());
        String[] command = sc.nextLine().split(" ");
        while (!command[0].equals("Party!")) {
            Predicate<String> predicate = getPredicate(command);
            if (command[0].equals("Double")) {
                List<String> newList = new ArrayList<>();
                people.stream().filter(predicate).forEach(newList::add);
                people.addAll(newList);
            } else {
                people.removeIf(predicate);
            }

            command = sc.nextLine().split(" ");
        }
        if(people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            Collections.sort(people);
            String result = String.join(", ",people)+ " are going to the party!";
            System.out.println(result);
        }
    }

    public static Predicate<String> getPredicate(String[] commands) {
        Predicate<String> predicate = null;
        String nameFilter = commands[1];
        String criteriaFilter = commands[2];
        switch (nameFilter) {
            case "StartsWith":
                predicate = name -> name.startsWith(criteriaFilter);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(criteriaFilter);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(criteriaFilter);
                break;
        }
        return predicate;
    }
}
