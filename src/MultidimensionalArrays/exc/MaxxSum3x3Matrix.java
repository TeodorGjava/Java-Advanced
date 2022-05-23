package MultidimensionalArrays.exc;

import java.util.Arrays;
import java.util.Scanner;

public class MaxxSum3x3Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] size = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] line = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row] = line;
            }
        }
        int[][] result = new int[3][3];
        int maxSum = Integer.MIN_VALUE;
        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
                int currSum = matrix[r][c]
                        + matrix[r][c + 1] + matrix[r][c + 2]
                        + matrix[r + 1][c] + matrix[r + 1][c + 1] +
                        matrix[r + 1][c + 2] + matrix[r + 2][c] +
                        matrix[r + 2][c + 1]
                        + matrix[r + 2][c + 2];
                if (currSum > maxSum) {
                    maxSum = currSum;
                    result = new int[][]{
                            {matrix[r][c], matrix[r][c + 1], matrix[r][c + 2]},
                            {matrix[r + 1][c], matrix[r + 1][c + 1], matrix[r + 1][c + 2]},
                            {matrix[r + 2][c], matrix[r + 2][c + 1], matrix[r + 2][c + 2]}
                    };
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        print(result);
    }

    private static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
