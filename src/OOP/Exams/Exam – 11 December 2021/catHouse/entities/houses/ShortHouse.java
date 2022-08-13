package catHouse.entities.houses;

public class ShortHouse extends BaseHouse{
    //Has 15 capacity.
    private static final int CAPACITY =15;

    public ShortHouse(String name) {
        super(name,CAPACITY);
    }
}
