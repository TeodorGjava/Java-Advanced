package Iterattor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthors();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setTitle(String... newTitle) {
        if (newTitle.length == 0) {
            System.out.println("!");
        } else {
            this.authors = Arrays.asList(newTitle);
        }
    }
}
