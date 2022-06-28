package Advanced.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String diagonal1 = "";
        StringBuilder diagonal2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            diagonal1 += arr[i] + " ";
            if(i==n-1) {
                diagonal2.append(arr[arr.length - 1 - i]);
            }else{
                diagonal2.append(arr[arr.length - 1 - i] + " ");
            }}
        diagonal2.delete(diagonal2.length()-1,diagonal2.length()-1);
        System.out.println(diagonal1);
        System.out.println(diagonal2.reverse());
    }
}
