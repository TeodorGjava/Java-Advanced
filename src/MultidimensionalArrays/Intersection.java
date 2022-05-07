package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Intersection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = Integer.parseInt(sc.nextLine());
        int C = Integer.parseInt(sc.nextLine());
        int[][] chars1 = new int[R][C];
        for (int row = 0; row < R; row++) {
            char[] tokens = sc.nextLine().toCharArray();
            int[] arr = new int[C];
            int a = 0;
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i] != 32) {
                    arr[a] = tokens[i];
                    a++;
                }
            }
            for (int col = 0; col < C; col++) {
                chars1[row][col] = arr[col];
            }
        }
        int[][] chars2 = new int[R][C];
        for (int row = 0; row < R; row++) {
            char[] tokens = sc.nextLine().toCharArray();
            int[] arr = new int[C];
            int a = 0;
            for (int i = 0; i < tokens.length; i++) {

                if (tokens[i] != 32) {
                    arr[a] = tokens[i];
                    a++;
                }
            }
            for (int col = 0; col < C; col++) {
                chars2[row][col] = arr[col];
            }
        }
        int[][] chars3 = new int[R][C];
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (chars1[row][col] == chars2[row][col]) {
                    chars3[row][col] = chars1[row][col];
                } else {
                    chars3[row][col] = '*';
                }
            }
        }
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (chars3[row][col] != 32) {
                    System.out.print((char) chars3[row][col] + " ");
                }
            }
            System.out.println();
        }

    }
}
