package MultidimensionalArrays.exc;

import java.util.Arrays;
import java.util.Scanner;

public class ShuffleMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sizes = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = sizes[0];
        int cols = sizes[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = sc.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row] = line;
            }
        }
        String[] command = sc.nextLine().split("\\s+");
        while (!command[0].equals("END")) {
            if(!command[0].equals("swap")){
                wrong();
            }else{
            int r1 = Integer.parseInt(command[1]);
            int c1 = Integer.parseInt(command[2]);
            int r2 = Integer.parseInt(command[3]);
            int c2 = Integer.parseInt(command[4]);
            if (command[0].equals("swap") && r1 <= rows - 1 && r2 <= rows - 1 && c1 <= cols - 1 && c2 <= cols - 1) {
                String first = matrix[r1][c1];
                matrix[r1][c1] = matrix[r2][c2];
                matrix[r2][c2] = first;
                print(matrix, rows, cols);
            }else{
                wrong();
            }}
            command = sc.nextLine().split("\\s+");
        }
    }
    private static void wrong(){
        System.out.println("Invalid input!");
    }
    private static void print(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
