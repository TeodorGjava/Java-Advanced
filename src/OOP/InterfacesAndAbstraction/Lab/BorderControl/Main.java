package OOP.InterfacesAndAbstraction.Lab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        List<Identifiable> identifiableList = new ArrayList<>();

        while (!input.equals("End")){
            String[] data = input.split(" ");
            Identifiable identifiable =
                    data.length==2 ? new Robot(data[1],data[0])
                            :new Citizen(data[2],Integer.parseInt(data[1]),data[1]);
                identifiableList.add(identifiable);

            input=sc.nextLine();
        }
        String fakeId = sc.nextLine();

        identifiableList
                .stream()
                .map(Identifiable::getId)
                .filter(i->i.endsWith(fakeId))
                .forEach(System.out::println);
    }
}
