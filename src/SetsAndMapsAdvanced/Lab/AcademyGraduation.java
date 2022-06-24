package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Double[]> studentsAndScores = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();

            String[] gradeInput = sc.nextLine().split(" ");
            Double[] grades = new Double[gradeInput.length];

            for (int grade = 0; grade < gradeInput.length; grade++) {
                grades[grade] = Double.parseDouble(gradeInput[grade]);
            }
            studentsAndScores.put(name, grades);
        }
        studentsAndScores.forEach((k, v) -> {
            double sumScores = 0;
            for (Double grade : v) {
                sumScores += grade;
            }
            System.out.printf("%s is graduated with %s%n", k, sumScores / v.length);
        });
    }
}
