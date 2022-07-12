package OOP.Polymorphism.Lab.Animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    abstract String explainSelf();
}
