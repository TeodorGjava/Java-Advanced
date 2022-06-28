package Advanced.SetsAndMapsAdvanced.Lab;

import java.util.*;

public class AvgStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int records = Integer.parseInt(sc.nextLine());
        Map<String, List<Double>> map = new TreeMap<>();
        for (int i = 0; i < records; i++) {
            String[] input = sc.nextLine().split(" ");
            map.putIfAbsent(input[0], new ArrayList<>());
            if (map.containsKey(input[0])) {
                map.get(input[0]).add(Double.parseDouble(input[1]));
            }
        }
        map.forEach((key, value) -> {
            final double[] sum = {0};
            System.out.print(key + " -> ");
            value.stream().forEach(x -> System.out.printf("%.2f ",x));
            value.stream().forEach(x-> sum[0] +=x);
            System.out.printf("(avg: %.2f)%n", (double) sum[0] / value.size());
            sum[0]=0;


        });
    }
}