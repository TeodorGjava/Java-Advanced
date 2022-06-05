package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumOf2x2Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sizes = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = sizes[0];
        int cols = sizes[1];
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = arr[j];
            }
        }
        int[][] result = new int[2][2];
        int currentMaxSum = Integer.MIN_VALUE;
        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < cols - 1; c++) {
                int currSum = matrix[r][c]
                        + matrix[r][c + 1]
                        + matrix[r + 1][c] + matrix[r + 1][c + 1];
                if (currentMaxSum < currSum) {
                    currentMaxSum = currSum;
                    result = new int[][]{
                            {matrix[r][c], matrix[r][c + 1]},
                            {matrix[r + 1][c], matrix[r + 1][c + 1]}
                    };
                }
            }
        }
        printMatrix(result);
        System.out.println(currentMaxSum);
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
