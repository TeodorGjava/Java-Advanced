package OOP.Polymorphism.Liskov;

public class Main {
    public static void main(String[] args) {
        Animal animal= new Animal();

        Animal dog = new Dog();

        animal.eat();

        dog.eat();

    }
}
