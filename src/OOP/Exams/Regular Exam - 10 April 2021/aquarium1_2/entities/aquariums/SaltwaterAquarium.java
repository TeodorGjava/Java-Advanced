package aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium {
    private int capacity;
    public SaltwaterAquarium(String name) {
        super(name,25) ;

    }

    public void setCapacity() {
        this.capacity --;
    }
}
