package aquarium;

import org.junit.Test;

import static org.junit.Assert.*;

public class FishTest {
    private Fish fish;

@Test
    public void test_FishAvailable(){
    fish= new Fish("Nemo");
    assertTrue(fish.isAvailable());
}
}