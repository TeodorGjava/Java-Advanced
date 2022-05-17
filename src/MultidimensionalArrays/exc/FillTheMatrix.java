package MultidimensionalArrays.exc;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(", ");
        switch (input[1]) {
            case "A":
                print(patternA(Integer.parseInt(input[0])));
                break;
            case "B":
                print(patternB(Integer.parseInt(input[0])));
                break;
        }
    }

    public static int[][] patternA(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++, num++) {
                matrix[j][i] = num;
            }
        }
        return matrix;
    }

    public static void print(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr.length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] patternB(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        for (int i = 0; i < n; i++) {
            int x = n;
            for (int j = 0; j < n; j++, num++) {
                if (i==0) {
                    matrix[j][i] = num;
                }else if(i%2==0){
                    num+=n;
                    matrix[j][i]=num;
                    num-=n;
                } else {
                    matrix[j][i] = num + x;
                    num--;
                    x--;
                }
            }
        }
        return matrix;
    }
}
