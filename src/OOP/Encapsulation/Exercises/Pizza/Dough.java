package OOP.Encapsulation.Exercises.Pizza;

public class Dough {
    //flourType: String
    //bakingTechnique: String
    //weight: double
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.flourType = flourType;
        this.bakingTechnique = bakingTechnique;
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {

        this.weight = weight;
    }

    public double calculateCalories() {
        return 0;
    }
}
