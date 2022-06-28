package OOP.workingWithAbstraction;

import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        printRhombus(n,n-1);

    }

    private static void printRhombus(int size,int i) {
        for (int j = 0; j <=size ; j++) {
            System.out.print(" ");
        }

    }

}
