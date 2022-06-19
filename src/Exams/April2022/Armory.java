package Exams.April2022;

import java.util.Scanner;

public class Armory {
    private static int row = 0;
    private static int col = 0;
    private static boolean isInField = true;
    private static int gold = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        char[][] field = new char[size][size];

        for (int r = 0; r < size; r++) {
            String line = sc.nextLine();
            field[r] = line.toCharArray();

            if (line.contains("A")) {
                row = r;
                col = line.indexOf("A");
            }
        }

        while (isInField && gold < 65) {
            String command = sc.nextLine();
            switch (command) {
                case "up":
                    moveSoldier(field, -1, 0);
                    break;
                case "down":
                    moveSoldier(field, 1, 0);
                    break;
                case "left":
                    moveSoldier(field, 0, -1);
                    break;
                case "right":
                    moveSoldier(field, 0, 1);
                    break;

            }
        }
        System.out.printf("The king paid %d gold coins.%n", gold);
        printMatrix(field);
    }

    private static void moveSoldier(char[][] field, int rowMutate, int colMutate) {
        int nextRow = row + rowMutate;
        int nextCol = col + colMutate;

        boolean isOnMirror = false;

        if (!isInBounds(field, nextRow, nextCol)) {
            field[row][col] = '-';
            isInField = false;
            System.out.println("I do not need more swords!");
            return;
        }
        if (Character.isDigit(field[nextRow][nextCol])) {
            gold += Integer.parseInt(String.valueOf(field[nextRow][nextCol]));
            field[row][col] = '-';
            field[nextRow][nextCol] = 'A';
        } else if (field[nextRow][nextCol] == 'M') {
            field[row][col] = '-';
            isOnMirror = true;
        } else if (field[nextRow][nextCol] == '-') {
            field[row][col] = '-';
            field[nextRow][nextCol] = 'A';
        }
        row = nextRow;
        col = nextCol;
        if (isOnMirror) {
            int[] indexes = findOtherMirror(field);
            field[nextRow][nextCol] = '-';
            field[indexes[0]][indexes[1]] = 'A';
            row = indexes[0];
            col = indexes[1];
        }
        if (gold >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
            return;
        }

    }

    private static void printMatrix(char[][] field) {
        for (char[] arr : field) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static int[] findOtherMirror(char[][] field) {
        int[] indecies = new int[2];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'M') {
                    indecies[0] = i;
                    indecies[1] = j;
                }
            }
        }
        return indecies;
    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }
}
