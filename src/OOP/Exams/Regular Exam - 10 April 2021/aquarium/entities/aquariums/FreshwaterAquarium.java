package aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium{
private  int capacity;
    public FreshwaterAquarium(String name) {
        super(name,50);
    }

    public void setCapacity() {
        this.capacity --;
    }
}
