package Advanced.Generics.Exc.GenericCount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Swap<Double> box = new Swap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            box.add(Double.parseDouble(s));
        }
        String element = sc.nextLine();
        System.out.println(box.countGraterItems(Double.parseDouble(element)));
    }
}
