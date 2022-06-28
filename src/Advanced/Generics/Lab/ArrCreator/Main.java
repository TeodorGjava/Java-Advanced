package Advanced.Generics.Lab.ArrCreator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    Integer[] arr = ArrayCreator.create(4,59);
        for (Integer x:arr
             ) {
            System.out.println(x);
        }
        Integer[] arr2 = ArrayCreator.create(Integer.class,4,539);
        Arrays.stream(arr2).forEach(System.out::println);
    }

}
