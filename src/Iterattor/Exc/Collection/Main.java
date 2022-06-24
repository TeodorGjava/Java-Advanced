package Iterattor.Exc.Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Collection listyIterator = null;
        while (!input.equals("END")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Create":
                    // manual array copy
                    //String[] elements = new String[command.length-1];
                    // for (int i = 1; i <command.length ; i++) {
                    //     elements[i-1]= command[i];
                    // }

                    //method Arrays.copyOfRange(command,from: 1,command.length)
                    listyIterator = new Collection(Arrays.copyOfRange(command, 1, command.length));
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "PrintAll":
                  listyIterator.printAll();
            }
            input = sc.nextLine();
        }
    }
}
