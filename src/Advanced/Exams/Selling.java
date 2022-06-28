package Advanced.Exams;

import java.util.Arrays;
import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[][] matrix = new String[n][n];

        for (int row = 0; row <n ; row++) {
            String[] line =sc.nextLine().split(" ");
            for (int col = 0; col <n ; col++) {
                matrix[row] = line;
            }
        }
        int neededMoney = 50;
        int currentCash = 0;
        while (currentCash<neededMoney){


        }
        System.out.println();
    }
}
