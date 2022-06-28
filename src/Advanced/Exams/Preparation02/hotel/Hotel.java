package Advanced.Exams.Preparation02.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public int getCount() {
        return roster.size();
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream()
                .filter(p -> p.getName().equals(name) && p.getHometown().equals(hometown)).findFirst().orElse(null);


    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", this.name));
        for (Person p : roster
        ) {
            sb.append(String.format("%s%n", p.toString()));
        }
        return sb.toString();
    }
}
