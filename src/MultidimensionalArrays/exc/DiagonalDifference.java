package MultidimensionalArrays.exc;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int primary = 0;
        int secondary = 0;
        int counter = size - 1;
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++, counter--) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < arr.length; col++) {
                matrix[row] = arr;
                if (row == col) {
                    primary += matrix[row][col];
                }
            }
            secondary += matrix[row][counter];
        }
        System.out.println(Math.abs(primary - secondary));
    }
}
