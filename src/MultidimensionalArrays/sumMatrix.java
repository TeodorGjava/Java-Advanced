package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class sumMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] size = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];

        for (int row = 0; row <size[0] ; row++) {
            int[] tokens = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col <size[1] ; col++) {
                matrix[row][col]=tokens[col];
            }
        }
        int sum = 0;
        for (int i = 0; i <size[0] ; i++) {
            for (int j = 0; j <size[1] ; j++) {
                sum+=matrix[i][j];
            }
        }
        System.out.println(size[0]);
        System.out.println(size[1]);
        System.out.println(sum);
    }
}
