package OOP.InterfacesAndAbstraction.Exercises.FoodShortage;

public class Rebel implements Person, Buyer {
    private String name;
    private int age;
    private String group;
    private int food ;

    private  void setFood() {
        food += 5;
    }

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public void buyFood() {
        setFood();
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}
