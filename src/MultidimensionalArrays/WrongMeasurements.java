package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //3
        //1 2 4
        //4 6 7
        //8 9 4
        //1 0
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i <n ; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j <arr.length ; j++) {
                matrix[i][j]=arr[j];
            }
        }
        int[] x = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row= x[0];
        int col= x[1];

        System.out.println();
    }
}
