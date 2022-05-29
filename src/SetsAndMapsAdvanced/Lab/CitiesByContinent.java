package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class CitiesByContinent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Map<String, List<String>>> destinations = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            destinations.putIfAbsent(continent, new LinkedHashMap<>());
            destinations.get(continent).putIfAbsent(country, new ArrayList<>());
            destinations.get(continent).get(country).add(city);

        }

        destinations.forEach((key, value) -> {
            System.out.printf("%s:%n", key);
            value.entrySet().stream().forEach((x) -> {
                String cities = "";
                for (int i = 0; i < x.getValue().size(); i++) {
                    if (i != x.getValue().size() - 1) {
                        cities += x.getValue().get(i) + ", ";
                    }else{
                        cities += x.getValue().get(i);
                    }
                }
                System.out.printf("  %s -> ", x.getKey());
                String finalCities = cities;
                x.getValue().forEach(val -> finalCities.concat(val + ", "));
                System.out.print(finalCities);
                System.out.println();
            });
        });
    }
}
