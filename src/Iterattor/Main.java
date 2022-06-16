package Iterattor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book book1 = new Book("Animal farm", 2003, "George Orwell");
        Book book2 = new Book("Animal farm", 2003, "George Orwell", "Robert");
        Book book3 = new Book("Animal farm", 2003);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        if (book1.compareTo(book2) > 0) {
            System.out.printf("%s is before %s%n", book1, book2);
        } else if (book1.compareTo(book2) < 0) {
            System.out.printf("%s is before %s%n", book1, book2);
        } else {
            System.out.println("Book are equal");
        }
    }


}
