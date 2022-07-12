package OOP.Polymorphism.Lab.Animals;

public class Cat extends Animal{
    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        return String.format("I am %s and my favourite food is %s " +
                "MEEOW",super.getName(),super.getFavouriteFood());
    }
}
