package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm
    private static final int FARM_CAPACITY = 3;
    private static final String FARM_NAME = "Happy Farm";
    private static final int ANIMALS_COUNT = 2;
    private static final String ANIMAL_TO_REMOVE = "Cow";
    private Farm farm;
    private Farm fullFarm;
    private Animal animal;

    @Before
    public void setUp() {
        farm = new Farm("Tenzor", 3);
        animal = new Animal("Dog", 300);
        Animal goatAnimal = new Animal("Goat", 200);
        Animal cowAnimal = new Animal("Cow", 200);
        farm.add(goatAnimal);
        farm.add(animal);
        farm.add(cowAnimal);
    }

    @Test(expected = NullPointerException.class)
    public void test_Null_Name_Given_To_Farm_Constructor() {
        Farm testNullFarm = new Farm(null, 15);
    }

    @Test(expected = NullPointerException.class)
    public void test_WhiteSpace_Name_Given_To_Farm_Constructor() {
        Farm testNullFarm = new Farm("    ", 15);
    }

    @Test(expected = NullPointerException.class)
    public void test_Blank_Name_Given_To_Farm_Constructor()
    {
        Farm testNullFarm = new Farm("", 15);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_Adding_AnAnimal_With_Null_Type() {
        Animal testAnimal = new Animal(null, 2);
        farm.add(testAnimal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Zero_Capacity_Given_To_Constructor() {
        Farm testZeroCapacityFarm = new Farm("Test", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Adding_Existing_Animal_To_Farm() {
        farm.add(animal);
    }

    @Test
    public void test_getCount_method_Behavior_After_Adding_Some_Entities() {
        Assert.assertEquals(3, farm.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_Adding_AnAnimal_InFull_Farm() {
        Animal testAnimal = new Animal("pesho", 2);
        farm.add(testAnimal);
    }
    @Test
    public void test_Removing_AnAnimal_FromFarm(){
        Assert.assertTrue(farm.remove("Goat"));
    }

    @Test
    public void test_getCapacity_Method_Behavior_Returns_The_Real_Capacity() {
        Assert.assertEquals(FARM_CAPACITY, farm.getCapacity());
    }

    @Test
    public void test_Remove_Method_Removing_The_Added_Animal() {
        Assert.assertTrue(farm.remove("Dog"));
    }
    @Test
    public void test_Farm_getName(){
        Assert.assertEquals("Tenzor",farm.getName());
    }
    @Test
    public void test_Remove_Method_Removing_Not_Existing_Animal() {
        Assert.assertFalse(farm.remove("gog"));
    }
    @Test
    public void test_Remove_Method_Removing_Null_Animal() {
        Assert.assertFalse(farm.remove(null));
    }



}
