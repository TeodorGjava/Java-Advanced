package Exams.June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OsPlaning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>(); //stack
        ArrayDeque<Integer> threads = new ArrayDeque<>(); //queue
        Integer[] tasksInput = Arrays.stream(sc.nextLine().split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Integer[] threadsInput = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        Arrays.stream(tasksInput).forEach(tasks::push);
        Collections.addAll(threads, threadsInput);
        int taskToKill = Integer.parseInt(sc.nextLine());

        while (true){
            if (tasks.peek()==taskToKill){
                System.out.println("Thread with value "+ threads.peek()+" killed task "+ taskToKill);
                break;
            }else if(threads.peek()>=tasks.peek()){
                tasks.pop();
                threads.poll();
            }else{
                threads.poll();
            }
        }
        System.out.println(threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
