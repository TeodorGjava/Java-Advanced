package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium

    @Test(expected = NullPointerException.class)
    public void test_Null_NameGivenToAquarium() {
        Aquarium aquarium = new Aquarium(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void test_Empty_NameGivenToAquarium() {
        Aquarium aquarium = new Aquarium("", 10);
    }

    @Test(expected = NullPointerException.class)
    public void test_WhiteSpace_NameGivenToAquarium() {
        Aquarium aquarium = new Aquarium("  ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Bellow_Zero_capacity() {
        Aquarium aquarium = new Aquarium("Underworld", -1);
    }

    @Test
    public void test_getCount_Method() {
        Aquarium aquarium = new Aquarium("Underworld", 1);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_FishMethod_When_Aquarium_Is_Full() {
        Aquarium aquarium = new Aquarium("Underworld", 1);
        Fish fish = new Fish("Nemo");
        Fish fish2 = new Fish("Memo");
        aquarium.add(fish);
        aquarium.add(fish2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveFish_Method_When_Fish_DoesNot_Exist() {
        Aquarium aquarium = new Aquarium("Underworld", 1);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        aquarium.remove("Memo");
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_sellFish_Method_when_Fish_DoesNot_Exist(){
        Aquarium aquarium = new Aquarium("Underworld", 1);
        Fish fish = new Fish("Nemo");
        aquarium.add(fish);
        aquarium.sellFish("Memo");
    }


}