package MultidimensionalArrays.exc;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(", ");

        if (Integer.parseInt((input[0])) == 1) {
            System.out.println(1);
            return;
        }
        if (Integer.parseInt(input[0]) == 0) {
            System.out.println(0);
            return;
        }
        switch (input[1]) {
            case "A":
                print(patternA(Integer.parseInt(input[0])));
                break;
            case "B":
                print(patternB(Integer.parseInt(input[0])));
                break;
        }
    }

    public static int[][] patternA(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++, num++) {
                matrix[j][i] = num;
            }
        }
        return matrix;
    }

    public static void print(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr.length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] patternB(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {

                for (int j = 0; j < n; j++, num++) {
                    matrix[j][i] = num;
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    matrix[j][i] = num++;
                }
            }
        }
        return matrix;
    }
}
