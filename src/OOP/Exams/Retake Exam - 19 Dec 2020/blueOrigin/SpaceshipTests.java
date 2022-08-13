package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    private Collection<Astronaut> astronauts;
    private Spaceship spaceship;
    private static final int ZERO_CAPACITY = 0;
    private Astronaut astronaut;


    @Before
    public void setUp() {
        spaceship = new Spaceship("Space X", 2);
        astronauts = new ArrayList<>();
        astronaut = new Astronaut("Pesho", 54);
        spaceship.add(astronaut);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_With_Null_Name_Given() {
        Spaceship ship = new Spaceship(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_With_Whitespace_Name_Given() {
        Spaceship ship = new Spaceship("   ", 2);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_With_Empty_Name_Given() {
        Spaceship ship = new Spaceship("", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_With_Capacity_Below_Zero() {
        Spaceship ship = new Spaceship("name", -1);
    }

    @Test
    public void test_Constructor_Working_Properly_With_Valid_Data() {
        Assert.assertEquals("Space X", spaceship.getName());
        Assert.assertEquals(2, spaceship.getCapacity());
        Assert.assertEquals(1, spaceship.getCount());
        Assert.assertEquals(1, spaceship.getCapacity() - spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Adding_Existing_Astronaut() {
        Astronaut astronaut2 = new Astronaut("Pesho", 54);

        spaceship.add(astronaut2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Adding_Astronaut_When_SpaceShip_IsFull() {
        Astronaut astronaut2 = new Astronaut("gosho", 54);
        Astronaut astronaut3 = new Astronaut("testFull", 54);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
    }

    @Test
    public void test_Remove_AstronautByName_Method_Returns_Correct() {

        String name = "Pesho";
        String name2 = "pepi";
        Assert.assertTrue(spaceship.remove(name));
        Assert.assertFalse(spaceship.remove(name2));

    }
}
