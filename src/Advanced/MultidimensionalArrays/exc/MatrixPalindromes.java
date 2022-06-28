package Advanced.MultidimensionalArrays.exc;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int first = 'a' + row;
                int second = 'a' + row + col;
                int third = 'a' + row;
                char[] abc = new char[3];
                abc[0] =(char) first;
                abc[1] = (char) second;
                abc[2] = (char) third;
                matrix[row][col] = String.valueOf(abc);

            }
        }
        print(matrix);

    }

    private static void print(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int i = 0; i < matrix[row].length; i++) {
                System.out.print(matrix[row][i] + " ");
            }
            System.out.println();
        }
    }
}
