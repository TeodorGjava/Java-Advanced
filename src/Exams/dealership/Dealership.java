package Exams.dealership;

import java.util.ArrayList;
import java.util.List;


public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }
    public void add(Car car){
        if(data.size()<capacity&&!data.contains(car)){
            data.add(car);
            capacity++;
        }
    }
    public boolean buy(String manufacturer, String model){
        for (Car car:data
             ) {
            if(car.getManufacturer().equals(manufacturer)&&car.getModel().equals(model)){
                data.remove(car);
                return true;
            }
        }
        return false;
    }
    public Car getLatestCar(){
        if(data.isEmpty()) {
            return null;
        }
        Car latest = data.stream().max((x,x1)->x.getYear()-x1.getYear()).get();
        return latest;
    }
    public Car getCar(String manufacturer, String model){
        Car exit = null;
        for (Car car:data
             ) {
            if(car.getManufacturer().equals(manufacturer)&&car.getModel().equals(model)){
                exit=car;
            }
        }
        return exit;
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in dealership "+this.name+":\n");
        for (Car car:data
             ) {
            sb.append(String.format("%s%n",car.toString()));
        }
        return sb.toString();
    }
}
