package MultidimensionalArrays.exc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int rotate = Integer.parseInt(line.split("[()]")[1]);
        String command = sc.nextLine();
        List<String> wordList = new ArrayList<>();
        int maxColLength = Integer.MIN_VALUE;
        while (!command.equals("END")) {
            int currLenght = command.length();
            if (currLenght > maxColLength) {
                maxColLength = currLenght;
            }
            wordList.add(command);
            command = sc.nextLine();
        }
        int rows = wordList.size();
        int cols = maxColLength;

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String word = wordList.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < word.length()) {
                    matrix[row][col] = word.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }

            }
        }
        int angle = rotate % 360;

        printMatrix(matrix, rows, cols, angle);

    }

    private static void printMatrix(char[][] matrix, int rows, int cols, int angle) {
        switch (angle) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                int a = rows - 1;
                for (int row = 0; row < rows; row++, a--) {
                    int b = cols - 1;
                    for (int col = 0; col < cols; col++, b--) {
                        System.out.print(matrix[a][b]);
                    }
                    System.out.println();
                }

                break;
            case 270:
                for (int col = cols-1; col >= 0; col--) {
                    for (int row = 0; row<rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
