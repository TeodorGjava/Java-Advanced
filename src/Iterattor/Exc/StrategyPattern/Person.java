package Iterattor.Exc.StrategyPattern;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %d%n",this.getName(),this.getAge());
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
