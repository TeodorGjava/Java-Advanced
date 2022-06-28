package Advanced.Exams.Preparation02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombField {
    private static int row = 0;
    private static int col = 0;
    private static int bombs = 0;
    private static boolean isEscaped = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        char[][] field = new char[size][size];

        List<String> commands = Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());

        for (int r = 0; r < size; r++) {
            String line = sc.nextLine();
            line = line.replaceAll(" ", "");
            field[r] = line.toCharArray();
            if (line.contains("s")) {
                row = r;
                col = line.indexOf("s");
            }
        }

        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);
            switch (command) {
                case "up":
                    moveSapper(field, -1, 0);
                    break;
                case "down":
                    moveSapper(field, 1, 0);
                    break;
                case "right":
                    moveSapper(field, 0, 1);
                    break;
                case "left":
                    moveSapper(field, 0, -1);
                    break;
            }

            if (isEscaped) {
                System.out.println("END! " + getBombs(field) + " bombs left on the field");
                return;
            }else if(getBombs(field) < 1) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
        }

        if (getBombs(field) > 0 && !isEscaped) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", getBombs(field), row, col);
        }
    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }

    private static int getBombs(char[][] field) {
        int bombs = 0;
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 'B') {
                    bombs++;
                }
            }
        }
        return bombs;
    }

    private static void moveSapper(char[][] field, int rowMutate, int colMutate) {
        int nextRow = row + rowMutate;
        int nextCol = col + colMutate;

        if (isInBounds(field, nextRow, nextCol)) {
            if (field[nextRow][nextCol] == 'e') {
                isEscaped = true;
            }
            if (field[nextRow][nextCol] == 'B') {
                System.out.println("You found a bomb!");
                field[nextRow][nextCol] = '+';
                if (getBombs(field) < 1) {
                    return;
                }
            }
            row = nextRow;
            col = nextCol;

        }
    }
}
