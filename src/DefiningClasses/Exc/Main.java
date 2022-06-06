package DefiningClasses.Exc;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String,Cars> carsList = new LinkedHashMap<>();
        while (n-->0){
            String[] data = sc.nextLine().split(" ");
            String model = data[0];
            int fuel =Integer.parseInt(data[1]);
            double consumption =Double.parseDouble(data[2]);
            Cars car = new Cars(model,fuel,consumption);
            carsList.put(model,car);
        }
        String[] action = sc.nextLine().split(" ");
        while (!action[0].equals("End")){
            String car = action[1];
            int distance = Integer.parseInt(action[2]);
            carsList.get(car);

            action = sc.nextLine().split(" ");
        }

    }
}
