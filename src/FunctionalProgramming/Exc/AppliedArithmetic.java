package FunctionalProgramming.Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnaryOperator<List<Integer>> increment = integerList -> integerList
                .stream().map(e -> e + 1)
                .collect(Collectors.toList());
        UnaryOperator<List<Integer>> decrement = integerList -> integerList
                .stream().map(e -> e - 1)
                .collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = integerList -> integerList
                .stream().map(e -> e - 1)
                .collect(Collectors.toList());
        List<Integer> list = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = sc.nextLine();
        Consumer<List<Integer>> printer = e-> e.forEach(x-> System.out.printf("%s ",x));
        while (!input.equals("end")){
            switch (input){
                case "add":
                    list= increment.apply(list);
                    break;
                case"subtract":
                   list = decrement.apply(list);
                   break;
                case"multiply":
                 list = multiply.apply(list);
                 break;
                case "print":
                    printer.accept(list);
                    break;
                default:
                    System.out.println("No such command");
            }
            input = sc.nextLine();
        }
    }


}
