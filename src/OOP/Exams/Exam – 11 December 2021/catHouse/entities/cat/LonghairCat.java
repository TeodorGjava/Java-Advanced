package catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    private static final int INITIAL_KILOGRAMS = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        this.setKilograms(INITIAL_KILOGRAMS);
    }


    @Override
    public void eating() {
        this.setKilograms(getKilograms() + 3);
    }

}
