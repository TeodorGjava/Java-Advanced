package FunctionalProgramming.Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       List<String> list = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
    // accept String type elements
       Consumer<String> cons = System.out::println;
       //terminate
       list.forEach(cons);

    }
}
