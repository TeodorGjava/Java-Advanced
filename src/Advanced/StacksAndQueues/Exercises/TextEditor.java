package Advanced.StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;



public class TextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder stringBuilder = new StringBuilder();
        ArrayDeque<String> cmd = new ArrayDeque<>();
        ArrayDeque<String> deleted = new ArrayDeque<>();
        StringBuilder elements = new StringBuilder();

        for (int i = 0; i <n ; i++) {
            String[] command = sc.nextLine().split(" ");
            switch (command[0]){
                case "1":
                    cmd.push(command[0]);
                    addString(command[1],stringBuilder);
                    break;
                case "2":
                    cmd.push(command[0]);
                    int charsToDelete = Integer.parseInt(command[1]);
                    for (int j = stringBuilder.length()-charsToDelete; j <stringBuilder.length() ; j++) {
                        elements.append(stringBuilder.charAt(j));
                    }
                    remove(stringBuilder,charsToDelete);
                    break;
                case "3":
                    System.out.println(stringBuilder.charAt(Integer.parseInt(command[1])-1));
                    break;
                case "4":
                    //Ctrl+Z
                    String[] lastCommand = cmd.pop().split(" ");
                    String type = lastCommand[0];
                    switch (type){
                        case "1":
                            int elementsToDelete = elements.length();
                            remove(stringBuilder,elementsToDelete);
                            break;
                        case "2":
                            String elementsToAddBack = deleted.pop();
                            addString(elementsToAddBack,stringBuilder);
                            break;
                    }
                    break;
            }
        }
    }

    private static void remove(StringBuilder stringBuilder, int parseInt) {

        for (int i = 0; i <parseInt ; i++) {
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    private static void addString(String s, StringBuilder str) {
        str.append(s);
    }
}
