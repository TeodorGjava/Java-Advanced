package Advanced.DefiningClasses.Exc.OpinionPoll;

public class Person {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d",this.name,this.age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
