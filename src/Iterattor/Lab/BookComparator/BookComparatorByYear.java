package Iterattor.Lab.BookComparator;

import java.util.Comparator;

public class BookComparatorByYear implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return Integer.compare(o1.getYear(),o2.getYear());
    }
}
