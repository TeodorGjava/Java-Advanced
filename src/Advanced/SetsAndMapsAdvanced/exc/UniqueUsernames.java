package Advanced.SetsAndMapsAdvanced.exc;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i <n ; i++) {
            String name = sc.nextLine();
            usernames.add(name);
        }
        for (String s: usernames
             ) {
            System.out.println(s);
        }
    }
}
