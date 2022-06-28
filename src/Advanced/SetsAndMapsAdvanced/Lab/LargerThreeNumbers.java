package Advanced.SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargerThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        if(nums.size()<=3){
            nums.stream().sorted((x1,x2)->x2.compareTo(x1)).limit(3).forEach(x->{
                System.out.print(x+" ");
            });
        }else{

            nums.stream().sorted((x1,x2)->x2.compareTo(x1)).limit(3).forEach(x->{
                System.out.print(x+" ");
            });
        }
    }
}
