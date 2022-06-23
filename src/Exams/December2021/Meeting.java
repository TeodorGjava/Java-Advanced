package Exams.December2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    private static int matches = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> males = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).filter(x -> x > 0).collect(Collectors.toList());

        List<Integer> females = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).filter(x -> x > 0).collect(Collectors.toList());


        while (males.size() > 0 && females.size() > 0) {

            int firstMale = males.get(males.size() - 1);
            int firstFemale = females.get(0);
            if (firstFemale % 25 == 0) {
                females.remove(0);
                females.remove(0);
                if (females.size() == 0) {
                    break;
                }

            }
            if (firstMale % 25 == 0) {
                males.remove(males.size() - 1);
                if (males.size() == 0) {
                    break;
                }
            }
            if (firstFemale == firstMale) {
                matches++;
                males.remove(males.size() - 1);
                females.remove(0);
            } else {
                females.remove(0);
                males.remove(males.size() - 1);
                if (firstMale - 2 > 0) {
                    males.add(males.size(), firstMale - 2);
                }
            }
        }

        System.out.println("Matches: " + matches);
        if (males.size() > females.size()) {
            System.out.println("Males left: " + exit(males));
            System.out.println("Females left: none");
        } else {
            System.out.println("Males left: none");
            System.out.println("Females left: " + exit(females));
        }

    }

    public static String exit(List<Integer> list) {
        StringBuilder str = new StringBuilder();
        for (int l = 0; l < list.size(); l++) {
            if (l == list.size() - 1) {
                str.append(list.get(l));
            } else {
                str.append(list.get(l) + ", ");
            }
        }
        return str.toString();
    }
}
