package Advanced.FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            people.put(name, age);
        }
        Predicate<String> older = x -> x.equals("older");
        String criteria = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        String[] params = sc.nextLine().split(" ");
        if (params.length < 2) {
            if (params[0].equals("age")) {
                if (older.test(criteria)) {
                    people.values().stream().filter(x -> x >= age).forEach(e -> System.out.printf("%d%n", e));
                } else {
                    people.values().stream().filter(x -> x <= age).forEach(e -> System.out.printf("%d%n", e));
                }
            } else {
                if(older.test(criteria)){
                    people.entrySet().stream().filter(x->x.getValue()>=age).forEach(e-> System.out.println(e.getKey()));
                }else{
                    people.entrySet().stream().filter(x->x.getValue()<=age).forEach(e-> System.out.println(e.getKey()));

                }
            }
        } else {
            if (older.test(criteria)) {
                var entry = people.entrySet();
                entry.stream().filter(x -> x.getValue() >= age).forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
            } else {
                var entry = people.entrySet();
                entry.stream().filter(x -> x.getValue() <= age).forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
            }
        }
    }
}
