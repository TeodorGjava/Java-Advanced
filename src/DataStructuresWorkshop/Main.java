package DataStructuresWorkshop;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        SmartArray smartArray = new SmartArray();

        IntStream.rangeClosed(1,1024).forEach(smartArray::add);

        while (smartArray.size()>0){
            smartArray.add(8);
            smartArray.remove(smartArray.size()-1);
        }

    }


}
