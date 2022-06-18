package Exams;

import java.util.Scanner;

public class MouseAndCheese {
    private static boolean mouseIsInField = true;
    private static int row = 0;
    private static int col = 0;
    private static int cheeseCollection = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        char[][] field = new char[n][n];

        for (int r = 0; r < n; r++) {
            String line = sc.nextLine();
            field[r] = line.toCharArray();
            if (line.contains("M")) {
                row = r;
                col = line.indexOf("M");
            }
        }
        //3
        //-M-
        //ccc
        //---
        String command = sc.nextLine();
        System.out.println();
        while (!command.equals("end") && mouseIsInField) {
            switch (command) {
                case "up" -> moveMouse(field, -1, 0);
                case "down" -> moveMouse(field, 1, 0);
                case "left" -> moveMouse(field, 0, -1);
                case "right" -> moveMouse(field, 0, 1);
            }
            if(!mouseIsInField){
                break;
            }

            command = sc.nextLine();
        }
        if (!mouseIsInField) {
            System.out.println("Where is the mouse?");
        }
        if (cheeseCollection >= 5) {
            System.out.println("Great job, the mouse is fed " + cheeseCollection + " cheeses!");
        } else {
            System.out.println("The mouse couldn't eat the cheeses, she needed " +
                    (5 - cheeseCollection) + " cheeses more.");
        }
        printMatrix(field);
    }

    private static void moveMouse(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        boolean isOnBonusField = false;

        if (!isInBounds(field, nextRow, nextCol)) {
            field[row][col] = '-';
            mouseIsInField = false;
            return;
        }
        if (field[nextRow][nextCol] == 'c') {
            cheeseCollection++;
        } else if (field[nextRow][nextCol] == 'B') {
            isOnBonusField = true;
        }
        field[row][col] = '-';
        field[nextRow][nextCol] = 'M';
        row = nextRow;
        col = nextCol;
        if(isOnBonusField){
            moveMouse(field,rowMutator,colMutator);
        }
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
