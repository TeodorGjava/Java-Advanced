package FunctionalProgramming.Exc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] nums = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Comparator<Integer> comparator = (num1, num2)->{
            if(num1%2==0&&num2%2!=0){
                //n1- even
                //n2-odd
                return -1;
            }else if(num1%2==1&&num2%2==0){
                //opposite
                return 1;
            }else{
                return num1.compareTo(num2);
            }
        };
        Arrays.sort(nums,comparator);
        Arrays.stream(nums).forEach(e-> System.out.print(e+ " "));
    }
}
