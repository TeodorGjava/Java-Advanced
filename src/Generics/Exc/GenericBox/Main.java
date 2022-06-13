package Generics.Exc.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        GenericBox<Integer> box = new GenericBox<>();
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(sc.nextLine());
            box.add(s);
        }
        System.out.println(box);

    }
}
