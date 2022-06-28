package Advanced.Exams.August2021;

import java.util.Scanner;

public class Formula {
    static int row;
    static int col;
    static boolean finished = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int commands = Integer.parseInt(sc.nextLine());
        char[][] field = new char[size][size];

        for (int r = 0; r < size; r++) {
            String line = sc.nextLine();
            field[r] = line.toCharArray();
            if (line.contains("P")) {
                row = r;
                col = line.indexOf("P");
            }
        }
        String command = sc.nextLine();
        while (!finished && commands-- > 0) {
            switch (command) {
                case "up":
                    move(field, -1, 0);
                    break;
                case "down":
                    move(field, 1, 0);
                    break;
                case "left":
                    move(field, 0, -1);
                    break;
                case "right":
                    move(field, 0, 1);
                    break;

            }
            command = sc.nextLine();
        }
        if (finished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(field);

    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }

    private static void move(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;
        boolean isOnBonusField = false;
        if (isInBounds(field, nextRow, nextCol)) {
            if (field[nextRow][nextCol] != 'T') {
                if (field[nextRow][nextCol] == 'F') {
                    finished = true;
                    field[row][col] = '.';
                    field[nextRow][nextCol] = 'P';
                }
                if (field[nextRow][nextCol] == 'B') {
                    isOnBonusField = true;
                }
                field[row][col] = '.';
                field[nextRow][nextCol] = 'P';
                row = nextRow;
                col = nextCol;
                if (isOnBonusField) {
                    field[row][col] = 'B';
                    move(field, rowMutator, colMutator);
                }
            }
        } else {
            if (nextRow < 0) {
                nextRow = field.length-1;
            }
            if (nextRow < 0) {
                nextRow = field.length - 1;
            }
            if (nextCol > field.length) {
                nextCol = 0;
            }
            if (nextCol < 0) {
                nextCol = field.length - 1;
            }
            move(field, nextRow, 0);
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
}
