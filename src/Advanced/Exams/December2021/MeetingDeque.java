package Advanced.Exams.December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MeetingDeque {
    private static int matches = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> males = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).filter(x -> x > 0).collect(Collectors.toList());

        List<Integer> females = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).filter(x -> x > 0).collect(Collectors.toList());

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();

        for (Integer male : males
        ) {
            if (male != 0) {
                maleStack.push(male);
            }
        }
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();

        for (Integer female : females) {
            if (female != 0) {
                femaleQueue.offer(female);
            }
        }
        System.out.println();
        while (femaleQueue.size()>0&&maleStack.size()>0){
            int lastMale = maleStack.peek();
            int firstFemale = femaleQueue.poll();
            if(firstFemale%25==0){
                femaleQueue.poll();
                continue;
            }
            if(lastMale%25==0){
                maleStack.pop();
                continue;
            }
            if(firstFemale==lastMale){
                matches++;
                maleStack.pop();
            }else{
                maleStack.push(maleStack.pop()-2);
            }
        }
        System.out.println("Matches: " +matches);
        if(maleStack.isEmpty()){
            System.out.println("Males left: none");
            System.out.print("Females left: ");
            femaleQueue.forEach(System.out::println);
        }else{
            System.out.print("Males left: ");
            maleStack.forEach(System.out::println);
            System.out.print("Females left: none");
        }
    }

}
