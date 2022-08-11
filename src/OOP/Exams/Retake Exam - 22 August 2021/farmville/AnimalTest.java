package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    private static final double ANIMAL_ENERGY = 3;
    private Animal animal;

    @Before
    public void setUp(){
        animal=new Animal("Goat",ANIMAL_ENERGY);
    }
    @Test
    public void test_Animal_getEnergy_Method(){
        Assert.assertEquals(ANIMAL_ENERGY,animal.getEnergy(),0);
    }

}