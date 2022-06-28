package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnaryOperator<Double> priceWithVAT = aDouble -> aDouble*=1.2;
        List<Double> list = Arrays.stream(sc.nextLine().split(", ")).map(Double::parseDouble).collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        list.forEach(x->{
            x= priceWithVAT.apply(x);
            System.out.printf("%.2f%n",x);
        });
    }
}
