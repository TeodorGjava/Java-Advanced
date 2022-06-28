package Advanced.RegularExamJune2022;

import java.util.Scanner;

public class StickyFingers {
    private static int row = 0;
    private static int col = 0;
    private static int stolenMoney = 0;
    private static boolean isInJail = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        char[][] field = new char[n][n];
        String[] commands = sc.nextLine().split(",");

        for (int r = 0; r < n; r++) {
            String line = sc.nextLine().replace(" ", "");
            field[r] = line.toCharArray();
            if (line.contains("D")) {
                row = r;
                col = line.indexOf("D");
            }
        }
        for (int i = 0; i < commands.length; i++) {
            if(isInJail){
                break;
            }
            String command = commands[i];
            switch (command) {
                case "up":
                    move(field,-1,0);
                    break;
                case "down":
                    move(field,1,0);
                    break;
                case "left":
                    move(field,0,-1);
                    break;
                case "right":
                    move(field,0,1);
                    break;

            }
        }
        if(!isInJail){
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n",stolenMoney);
        }else{
            System.out.printf("You got caught with %d$, and you are going to jail.%n",stolenMoney);
        }
        printMatrix(field);
    }

    private static void move(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        // boolean isOnBonusField = false;

        if (!isInBounds(field, nextRow, nextCol)) {
            System.out.println("You cannot leave the town, there is police outside!");
            return;
        }
        if (field[nextRow][nextCol] == '$') {
            System.out.println("You successfully stole "+ nextRow*nextCol+"$.");
            stolenMoney += nextRow * nextCol;
        } else if (field[nextRow][nextCol] == 'P') {
            field[row][col] = '+';
            field[nextRow][nextCol]='#';
            isInJail = true;
            return;
        }
        field[row][col]='+';
        field[nextRow][nextCol]='D';
        row = nextRow;
        col = nextCol;
    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }


    private static void printMatrix(char[][] field) {
        for (char[] arr : field) {
            for (char c : arr) {
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
}
