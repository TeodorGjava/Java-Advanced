package Iterattor;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        if(person1.getName().length()==person2.getName().length()){
            char firstPersonChar = person1.getName().toLowerCase().charAt(0);
            char secondPersonChar = person2.getName().toLowerCase().charAt(0);
            return Character.compare(firstPersonChar,secondPersonChar);
        }
        return Integer.compare(person1.getName().length(),person2.getName().length());
    }
}
