package OOP.InterfacesAndAbstraction.Exercises.FoodShortage;

public class Citizen implements Identifiable, Buyer, Person {
    //-	name: String
    //-	age: int
    //-	id: String
    //-	birthDate: String
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    private void setFood(){
        this.food+=10;
    }


    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food=0;
    }

    public String getBirthDate() {
        return birthDate;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void buyFood() {
        setFood();
    }

    @Override
    public int getFood() {
        return food;
    }
}
