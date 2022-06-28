package Advanced.RegularExamJune2022.workout;

import java.util.ArrayList;

import java.util.List;

public class Workout {
    //•	type: String
    //•	exerciseCount: int
    List<Exercise> exercises;
    String type;
    int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise ex : this.exercises
        ) {
            if (ex.getName().equals(name) && ex.getMuscle().equals(muscle)) {
                this.exercises.remove(ex);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise ex : this.exercises
        ) {
            if (ex.getName().equals(name) && ex.getMuscle().equals(muscle)) {
                return ex;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (!this.exercises.isEmpty()) {
            Exercise exercise = this.exercises.get(0);
            for (Exercise ex : this.exercises
            ) {
                if (ex.getBurnedCalories() > exercise.getBurnedCalories()) {
                    exercise = ex;
                }
            }
            return exercise;
        }
        return null;
    }
    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        this.exercises.forEach(sb::append);
        return String.format("Workout type: %s%n%s",this.type, sb).trim();
    }

}
