package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class diagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(arr, 0, matrix[row], 0, n);
        }
        for (int row = 0; row < n; row++) {
            System.out.print(matrix[row][row] + " ");
        }
        System.out.println();
        int i = 0;
        for (int col = n - 1; col >= 0; col--, i++) {
            System.out.print(matrix[col][i] + " ");
        }
    }
}
