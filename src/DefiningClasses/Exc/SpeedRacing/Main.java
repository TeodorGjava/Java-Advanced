package DefiningClasses.Exc.SpeedRacing;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String,Cars> carsList = new TreeMap<>();
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
            Cars car1 = carsList.get(car);
            car1.drive(car,distance);
            action = sc.nextLine().split(" ");
        }
        carsList.forEach((key,value)-> System.out.printf("%s %.2f %d%n",key,value.getFuel(),value.getMileage()));

    }
}
