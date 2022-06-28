package Advanced.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sizes = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[sizes[0]][sizes[1]];
        for (int rows = 0; rows <sizes[0] ; rows++) {
            int[] tokens = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int cols = 0; cols <sizes[1] ; cols++) {
                matrix[rows][cols]=tokens[cols];
            }
        }
        int number = Integer.parseInt(sc.nextLine());
        boolean found = false;
        for (int rows = 0; rows <sizes[0] ; rows++) {
            for (int cols = 0; cols <sizes[1] ; cols++) {
                if(matrix[rows][cols]==number){
                    found=true;
                    System.out.println(rows+" "+ cols);
                }
            }
        }
        if(!found){
            System.out.println("not found");
        }
    }
}
