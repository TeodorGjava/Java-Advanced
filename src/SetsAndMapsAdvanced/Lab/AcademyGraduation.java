package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String,List<Double>> studentsAndScores= new TreeMap<>();
        for (int i = 0; i <n ; i++) {
                String name = sc.nextLine();
                List<Double> scores = Arrays.stream(sc.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
                studentsAndScores.put(name,scores);

        }
        for (var entry:studentsAndScores.entrySet()){
            String result = String.valueOf(entry.getValue().stream().mapToDouble((e)->e).average().getAsDouble());

            System.out.printf("%s is graduated with %s%n",entry.getKey(), String.valueOf(result));

        }
    }
}
