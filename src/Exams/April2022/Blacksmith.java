package Exams.April2022;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    private static int swords;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> steel = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> carbon = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(carbon::push);

        Map<String, Integer> forgedThings = new TreeMap<>();

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int lastCarbon = carbon.poll();
            int sum = steel.pop() + lastCarbon;

            String forged = null;
            switch (sum) {
                case 70:
                    forged = "Gladius";
                    if (!forgedThings.containsKey("Gladius")) {
                        forgedThings.put("Gladius", 1);
                    } else {
                        forgedThings.replace("Gladius", forgedThings.get("Gladius") + 1);
                    }
                    break;
                case 80:
                    forged = "Shamshir";
                    if (!forgedThings.containsKey("Shamshir")) {
                        forgedThings.put("Shamshir", 1);
                    } else {
                        forgedThings.replace("Shamshir", forgedThings.get("Shamshir") + 1);
                    }
                    break;
                case 90:
                    forged = "Katana";
                    if (!forgedThings.containsKey("Katana")) {
                        forgedThings.put("Katana", 1);
                    } else {
                        forgedThings.replace("Katana", forgedThings.get("Katana") + 1);
                    }
                    break;
                case 110:
                    forged = "Sabre";
                    if (!forgedThings.containsKey("Sabre")) {
                        forgedThings.put("Sabre", 1);
                    } else {
                        forgedThings.replace("Sabre", forgedThings.get("Sabre") + 1);
                    }
                    break;
            }
            if (forged == null) {
                carbon.push(lastCarbon + 5);
            }else{
                swords++;
            }
        }
        if (forgedThings.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            System.out.println("You have forged " + swords + " swords.");
        }
        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
           String s = Arrays.stream(steel.toArray()).map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Steel left:"+s);
        }
        if (carbon.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            String c = Arrays.stream(carbon.toArray()).map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Carbon left: "+ c);

        }
        forgedThings.forEach((k,v)-> System.out.printf("%s: %s%n",k,v));
    }
}
