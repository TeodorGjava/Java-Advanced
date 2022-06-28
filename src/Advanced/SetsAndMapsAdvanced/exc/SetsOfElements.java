package Advanced.SetsAndMapsAdvanced.exc;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sizes = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstSetSize = sizes[0];
        int secondSetSize = sizes[1];
        LinkedHashSet<Integer> setFirst= new LinkedHashSet<>();
        for (int i = 0; i <firstSetSize; i++) {
            setFirst.add(Integer.parseInt(sc.nextLine()));
        }
        LinkedHashSet<Integer> setSecond= new LinkedHashSet<>();
        for (int i = 0; i <secondSetSize ; i++) {
            int number = Integer.parseInt(sc.nextLine());
            if(setFirst.contains(number)){
                setSecond.add(number);
            }
        }
        for (int x :setSecond
             ) {
            System.out.print(x+" ");
        }
    }
}
