package OOP.Polymorphism.Exercises.Farm;

public class Tiger extends Felime{
    String livingRegion;

    public Tiger(String animalName, Double animalWeight,String livingRegion) {
        super(animalName, "Tiger", animalWeight, livingRegion);
        this.livingRegion=livingRegion;
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if(food instanceof Meat){
            setFoodEaten(food.getQuantity()+getFoodEaten());
        }else{
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}
