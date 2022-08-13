package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class HouseTests {
    private static final String EXPECTED_NAME = "HouseOfPain";
    private static final String EXPECTED_CAT_NAME = "Pesho";
    private static final int EXPECTED_CAPACITY = 3;
    private Collection<Cat> cats;
    private Cat cat;
    private String catName;
    private int capacity;
    private House house;
    private House house_Test;

    @Before
    public void setUp() {
        catName = EXPECTED_CAT_NAME;
        capacity = EXPECTED_CAPACITY;
        cat = new Cat(catName);
        house = new House(EXPECTED_NAME, capacity);
        cats = new ArrayList<>();
        house_Test=new House("Test", 1);
        house_Test.addCat(cat);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Capacity_Full() {
house_Test.addCat(new Cat("Peshko"));
    }

    @Test
    public void test_Constructor_Valid_Parameters_Passing() {
        House testHouse = new House("HouseOfPain", 3);

    }

    @Test(expected = NullPointerException.class)
    public void test_Passing_Null_Name_To_Constructor() {
        House testHouse = new House(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void test_Passing_Empty_Name_To_Constructor() {
        House testHouse = new House("", 3);
    }

    @Test(expected = NullPointerException.class)
    public void test_Passing_Whitespace_Name_To_Constructor() {
        House testHouse = new House("           ", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Passing_Bellow_Zero_Capacity() {
        House testHouse = new House("house", -3);
    }

    @Test
    public void test_Adding_Cat_Method() {
        assertTrue(cats.add(cat));
        house.addCat(cat);

        assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Removing_Non_Existing_Cat() {
        house.addCat(cat);
        house.removeCat("kuchi");
    }

    @Test
    public void test_Removing_Existing_Cat() {
        house.addCat(cat);
        house.removeCat(catName);
    }

    @Test
    public void test_CatForSale_Method_With_NonExistingName() {
        String name = "gogo";
        assertNull(cats.stream()
                .filter(f -> name.equals(f.getName()))
                .findAny()
                .orElse(null));
        house.addCat(cat);
        cats.add(cat);
        assertNotNull(cats.stream()
                .filter(f -> "Pesho".equals(f.getName()))
                .findAny()
                .orElse(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_catForSale_Method_Throwing_Exception() {
        house.catForSale("Peshunko");
    }

    @Test
    public void test_CatIsNotHungryWhenForSale() {
        house.addCat(cat);
        house.catForSale(catName);
        assertFalse(cat.isHungry());
    }
}
