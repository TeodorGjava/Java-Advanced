package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class compareMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr1 = new int[a[0]][a[1]];
        for (int rows = 0; rows < a[0]; rows++) {
            int[] tokens = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int cols = 0; cols < a[1]; cols++) {
                arr1[rows][cols] = tokens[cols];
            }
        }
        int[] b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr2 = new int[b[0]][b[1]];
        for (int rows = 0; rows < b[0]; rows++) {
            int[] tokens = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int cols = 0; cols < b[1]; cols++) {
                arr2[rows][cols] = tokens[cols];
            }
        }
        if(arraysCompare(arr1,arr2)){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }


    private static boolean arraysCompare(int[][] arr1, int[][] arr2) {
        if (arr1.length != arr2.length) {
            return false;}
        for (int row = 0; row < arr1.length; row++) {
            if (arr1[row].length != arr2[row].length) {
                return false;}
            for (int col = 0; col < arr1[row].length; col++) {
                if (arr1[row][col] != arr2[row][col]) {
                    return false;}}}
        return true;
    }
}
