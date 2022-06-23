package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        boolean isPresent = false;
        for (Fish f : this.fishInPool
        ) {
            if (f.getName().equals(fish.getName())) {
                isPresent = true;
                break;
            }
        }
        if (this.fishInPool.size() < this.getCapacity() && !isPresent) {
            this.fishInPool.add(fish);
        }
    }

    public void remove(String name) {
        boolean isRemoved = false;
        for (Fish fish: this.fishInPool
             ) {
            if(fish.getName().equals(name)){
                fishInPool.remove(fish);
                isRemoved=true;
            }
        }
        if (isRemoved){
            System.out.println("true");
        }
    }

    public Fish findFish(String name) {
        for (Fish fish : this.fishInPool
        ) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder str = new StringBuilder();
        for (Fish fish : this.fishInPool
        ) {
            str.append(fish.toString() + "\n");
        }
        return String.format("Aquarium: %s ^ Size: %s%n%s", this.getName(), this.getSize(), str.toString());
    }

    public void setFishInPool(List<Fish> fishInPool) {
        this.fishInPool = fishInPool;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
}
