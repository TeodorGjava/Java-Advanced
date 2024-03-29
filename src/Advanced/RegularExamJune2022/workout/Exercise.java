package Advanced.RegularExamJune2022.workout;

public class Exercise {
    //•	name: String
    //•	muscle: String
    //•	burnedCalories: int
    String name;
    String muscle;
    int burnedCalories;

    public Exercise(String name, String muscle, int burnedCalories) {
        this.name = name;
        this.muscle = muscle;
        this.burnedCalories = burnedCalories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public int getBurnedCalories() {
        return burnedCalories;
    }

    public void setBurnedCalories(int burnedCalories) {
        this.burnedCalories = burnedCalories;
    }

    @Override
    public String toString() {
        return String.format("Exercise: %s, %s, %s%n",this.getName(),this.getMuscle(), this.getBurnedCalories());

    }
}
