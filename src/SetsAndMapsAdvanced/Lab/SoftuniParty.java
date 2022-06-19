package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        TreeSet<String> vips = new TreeSet<>();
        TreeSet<String> regs = new TreeSet<>();
        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vips.add(input);
            } else {
                regs.add(input);
            }
            input = sc.nextLine();
        }
        input = sc.nextLine();
        while (!input.equals("END")) {
            if (regs.contains(input)) {
                regs.remove(input);
            }
            if (vips.contains(input)) {
                vips.remove(input);
            }
            input = sc.nextLine();
        }
        int missed = vips.size() + regs.size();
        System.out.println(missed);
        for (String vip : vips
        ) {
            System.out.println(vip);
        }
        for (String reg : regs
        ) {
            System.out.println(reg);
        }
    }
}
