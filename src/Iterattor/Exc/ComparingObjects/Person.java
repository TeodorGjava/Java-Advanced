package Iterattor.Exc.ComparingObjects;

public class Person implements Comparable<Person> {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    private String name;
    private int age;
    private String town;

    @Override
    public int compareTo(Person o) {
        //by name
        //by age
        //by town
        if (this.getName().equals(o.getName())) {
            if (this.getAge() == o.getAge()) {
                return this.getTown().compareTo(o.getTown());
            }
            return Integer.compare(this.getAge(), o.getAge());
        }
        return this.getName().compareTo(o.getName());
    }
}
