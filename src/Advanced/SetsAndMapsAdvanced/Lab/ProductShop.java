package Advanced.SetsAndMapsAdvanced.Lab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] command = sc.nextLine().split(", ");

        Map<String, Map<String,Double>> map = new TreeMap<>();
        while (!command[0].equals("Revision")){
            String name = command[0];
            String product = command[1];
            double price =Double.parseDouble(command[2]);
            map.putIfAbsent(name,new LinkedHashMap<>());
            map.get(name).put(product,price);
            command = sc.nextLine().split(", ");
        }
        map.forEach((key,value)->{
            System.out.println(key+"->");
            value.entrySet().stream().sorted((x1,x2)->(int)(x1.getValue()-x2.getValue()));
            value.entrySet().stream().forEach((x)->System.out.printf("Product: %s, Price: %.1f%n",x.getKey(),x.getValue()));
        });
    }
}
