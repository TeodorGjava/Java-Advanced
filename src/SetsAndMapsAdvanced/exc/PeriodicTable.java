package SetsAndMapsAdvanced.exc;

import com.sun.source.tree.Tree;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        TreeSet<String> setOfElements = new TreeSet<>();
        for (int i = 0; i <n ; i++) {
            String[] elements = sc.nextLine().split(" ");
            for (int j = 0; j <elements.length ; j++) {
                setOfElements.add(elements[j]);
            }
        }
        for (String element:setOfElements
             ) {
            System.out.print(element+" ");
        }
    }
}
