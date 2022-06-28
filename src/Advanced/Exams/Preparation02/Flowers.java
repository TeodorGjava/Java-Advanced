package Advanced.Exams.Preparation02;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Flowers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> lilies = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> roses = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> rosesStack = new ArrayDeque<>();

        for (int lilie : lilies
        ) {
            liliesStack.push(lilie);
        }
        for (int rose : roses
        ) {
            rosesStack.offer(rose);
        }
        int otherFlowers=0;
        int wreaths = 0;
        while(!liliesStack.isEmpty()&&!rosesStack.isEmpty()){
            int rose =rosesStack.poll();
            int lily = liliesStack.pop();

            int sum = lily+rose;
            while(sum>15){
                lily-=2;
                sum = lily+rose;
            }
            if(sum==15){
                wreaths++;
            }else if(sum<15){
                otherFlowers+=sum;
            }
        }
        wreaths+=otherFlowers/15;
        if(wreaths>=5){
            System.out.println("You made it, you are going to the competition with "+wreaths+" wreaths!");
        }else{
            System.out.printf("You didn't make it, you need %d wreaths more!%n",5-wreaths);
        }

    }
}
