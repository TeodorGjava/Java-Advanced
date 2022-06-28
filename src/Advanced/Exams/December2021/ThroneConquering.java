package Advanced.Exams.December2021;

import java.util.Scanner;

public class ThroneConquering {
    static int row;
    static int targetrow;
    static int col;
    static int targetcol;
    static boolean succeeded = false;

    static int energy = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        energy = Integer.parseInt(sc.nextLine());

        int n = Integer.parseInt(sc.nextLine());
        char[][] field = new char[n][n];

        for (int r = 0; r < n; r++) {
            String line = sc.nextLine();
            field[r] = line.toCharArray();

            if (line.contains("P")) {
                row = r;
                col = line.indexOf("P");
            }
            if (line.contains("H")) {
                targetrow = r;
                targetcol = line.indexOf("H");
            }
        }
        String[] command = sc.nextLine().split(" ");

        while (energy > 0 && !succeeded) {
            int r = Integer.parseInt(command[1]);
            int c = Integer.parseInt(command[2]);
            field[r][c] = 'S';

            switch (command[0]) {
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
            if (!isDead()&&!succeeded) {
                command = sc.nextLine().split(" ");
            } else {
                break;
            }
        }
        if (succeeded) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %s%n", energy);
        }
        if (energy < 1) {
            System.out.printf("Paris died at %d;%d.%n", row, col);
        }
        printMatrix(field);
    }

    private static void move(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        boolean isInFight = false;

        if (isInBounds(field, nextRow, nextCol)) {
            if (field[nextRow][nextCol] == 'S') {
                isInFight = true;
            }
            if (field[nextRow][nextCol] == field[targetrow][targetcol]) {
                field[row][col] = '-';
                field[nextRow][nextCol] = '-';
                succeeded = true;
            }
            if (isInFight) {
                energy -= 2;
                if (isDead()) {
                    field[row][col] = 'X';
                }
            }
            if (!succeeded) {
                field[row][col] = '-';
                field[nextRow][nextCol] = 'P';
                row = nextRow;
                col = nextCol;
            }
            energy--;
            if (isDead()) {
                field[row][col] = 'X';
            }
        } else {
            energy--;
            if (isDead()) {
                field[row][col] = 'X';
            }
        }

    }

    public static boolean isDead() {
        return energy < 1;
    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
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
