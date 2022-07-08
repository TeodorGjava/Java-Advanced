package OOP.Encapsulation.Exercises.Pizza;

import java.util.List;

public class Pizza {
    //name: String
    //dought:  Dough
    //toppings: List<Topping>
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, Dough dough) {
        this.name = name;
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public List<Topping>  getTopping() {
        return toppings;
    }


}
