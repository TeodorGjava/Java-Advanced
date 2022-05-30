package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class CountRealNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double,Integer> map = new LinkedHashMap<>();
        List<Integer> count = new ArrayList<>();
        for (double num : numbers
             ) {
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        for(Double key: map.keySet()){
            System.out.printf("%.1f -> %d%n",key,map.get(key));
        }
        }
    }

