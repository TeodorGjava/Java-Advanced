package Advanced.Algorithms.ArraySum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sumArray(arr,0));
    }
    public static int sumArray(int[] arr, int index){
        if(index==arr.length-1){
            return arr[index];
        }
        return arr[index] + sumArray(arr,index+1);
    }
}
