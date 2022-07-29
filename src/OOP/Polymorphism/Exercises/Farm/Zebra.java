package OOP.Polymorphism.Exercises.Farm;

public class Zebra extends Mammal{

    public Zebra(String animalName, Double animalWeight, String livingRegion) {
        super(animalName,"Zebra", animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if(food instanceof Vegetable){
            setFoodEaten(food.getQuantity()+getFoodEaten());
        }else{
            System.out.println("Zebras are not eating that type of food!");
        }
    }
}
