package Advanced.Exams.December2021.aquarium;

public class Main {
    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium("Ocean", 5, 15);
        // Initialize Fish
        Fish fish = new Fish("Goldy", "gold", 4);
        // Print Fish
        System.out.println(fish.toString());

        System.out.println(aquarium.findFish("nae"));
        // Print Aquarium report
        System.out.println(aquarium.report());

        //Aquarium Info:
        //Aquarium: Ocean ^ Size: 15
        //Fish: Dory
        //Color: blue
        //Number of fins: 2
        //Fish: Nemo
        //Color: orange
        //Number of fins: 5

    }
}
