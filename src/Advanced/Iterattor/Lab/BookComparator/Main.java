package Advanced.Iterattor.Lab.BookComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        List<Book> books = new ArrayList<>();

        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        books.stream()
                .sorted(new BookComparator())
                .sorted(new BookComparatorByYear())
                .forEach(x -> System.out.println(x.getTitle() + " " + x.getYear()));


    }
}


