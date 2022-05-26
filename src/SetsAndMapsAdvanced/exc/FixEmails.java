package SetsAndMapsAdvanced.exc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Map<String, String> map = new LinkedHashMap<>();
        while (!name.equals("stop")) {
            String email = sc.nextLine();
            if (!email.contains(".us") && !email.contains(".US") && !email.contains("uk") && !email.contains(".UK") && !email.contains(".COM") && !email.contains(".com")) {
                map.put(name, email);
            }
            name=sc.nextLine();
        }
        for (Map.Entry<String, String> entry : map.entrySet()
        ) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}