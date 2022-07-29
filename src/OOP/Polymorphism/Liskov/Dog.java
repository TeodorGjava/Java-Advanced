package OOP.Polymorphism.Liskov;

public class Dog extends Animal{
    public Dog() {
    }

    @Override
    public void eat() {
        System.out.println("The dog is eating");
    }
}
