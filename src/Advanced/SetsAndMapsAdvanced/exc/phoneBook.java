package Advanced.SetsAndMapsAdvanced.exc;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class phoneBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] contact = sc.nextLine().split("-");
        LinkedHashMap<String,String> phoneBook = new LinkedHashMap<>();
        while (!contact[0].equals("search")){
            String name = contact[0];
            String number = contact[1];
            if(!phoneBook.containsKey(name)){
                phoneBook.put(name,number);
            }else{
                phoneBook.replace(name,number);
            }
            contact=sc.nextLine().split("-");
        }
        String search = sc.nextLine();
        while (!search.equals("stop")){
            if(phoneBook.containsKey(search)){
                System.out.println(search + " -> "+ phoneBook.get(search));
            }else{
                System.out.println("Contact "+ search + " does not exist.");
            }
            search = sc.nextLine();
        }
    }
}
