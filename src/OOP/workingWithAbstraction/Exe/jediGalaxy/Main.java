package OOP.workingWithAbstraction.Exe.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int value = 0;
    private static long starsCollected = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = readPositions(sc.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] field = new int[rows][cols];


        createField(rows, cols, field);

        String command = sc.nextLine();

        while (!command.equals("Let the Force be with you")) {
            int[] jediStartPosition = readPositions(command);
            int[] evilPosition = readPositions(sc.nextLine());

            int rowEvil = evilPosition[0];
            int colEvil = evilPosition[1];

            while (rowEvil >= 0 && colEvil >= 0) {
                if (isInBounds(field, rowEvil, colEvil)) {
                    field[rowEvil][colEvil] = 0;
                }
                rowEvil--;
                colEvil--;
            }

            int rowJedi = jediStartPosition[0];
            int colJedi = jediStartPosition[1];

            while (rowJedi >= 0 && colJedi < field[1].length) {
                if (rowJedi < field.length && colJedi >= 0 && colJedi < field[0].length) {
                    starsCollected += field[rowJedi][colJedi];
                }

                colJedi++;
                rowJedi--;
            }

            command = sc.nextLine();
        }

        System.out.println(starsCollected);


    }

    private static boolean isInBounds(int[][] field, int rowEvil, int colEvil) {
        return rowEvil < field.length && colEvil < field[0].length;
    }

    private static int[] readPositions(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void createField(int rows, int cols, int[][] field) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                field[row][col] = value++;
            }
        }
    }
}
