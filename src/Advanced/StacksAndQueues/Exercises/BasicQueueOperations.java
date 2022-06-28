package Advanced.StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

                int[] params = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                int N = params[0];
                int S = params[1];
                int X = params[2];

                int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                ArrayDeque<Integer> queue = new ArrayDeque<>();

                for (int i = 0; i < N ; i++) {
                    queue.add(input[i]);
                }
                for (int i = 0; i <S ; i++) {
                    queue.poll();
                }
                if(queue.contains(X)){
                    System.out.println("true");
                }else if (queue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(queue.stream().min(Integer::compare).get());
                }
            }
        }
        