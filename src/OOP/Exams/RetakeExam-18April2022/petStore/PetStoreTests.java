package petStore;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTests {
    private static final String SPECIE = "Dog";
    private static final int MAX_WEIGHT = 30;
    private static final double PRICE = 100.00;

    private Animal animal;
    private PetStore petStore;

    @Before
    public void setUp() {
        this.petStore = new PetStore();
        this.animal = new Animal(SPECIE, MAX_WEIGHT, PRICE);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_getAnimals_ShouldReturn_UnmodifiableList() {
        List<Animal> animalList = petStore.getAnimals();
        animalList.remove(1);
    }

    @Test
    public void test_GetCount_ReturnsZeroWhenEmpty_AndOneWhen_SingleAnimalAdded() {
        assertEquals(0, petStore.getCount());
        petStore.addAnimal(animal);
        assertEquals(1, petStore.getCount());
    }

    @Test
    public void test_FindAllAnimalsWithMaxKilograms_Should_Return_EmptyList_WhenNoSuchAnimal() {
        petStore.addAnimal(animal);
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(MAX_WEIGHT + 10);
        assertTrue(animals.isEmpty());
    }

    @Test
    public void test_FindAllAnimalsWithMaxKilograms_Should_Return_OnlyThoseHeavier() {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("TEST", MAX_WEIGHT - 2, PRICE));
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(MAX_WEIGHT - 1);
        assertEquals(1, animals.size());
        assertEquals(animal.getSpecie(), animals.get(0).getSpecie());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddAnimal_Behavior_WhenAnimal_IsNull() {
        petStore.addAnimal(null);
    }

    @Test
    public void test_AddAnimal_Should_Increase_Count() {
        petStore.addAnimal(animal);
        assertEquals(1, petStore.getCount());
    }

    @Test
    public void test_GetMostExpensiveAnimal_Returning_Null_WhenEmpty() {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal(SPECIE, MAX_WEIGHT, PRICE - 10));
        Animal actualAnimal = petStore.getTheMostExpensiveAnimal();
        assertEquals(animal.getPrice(),actualAnimal.getPrice(),0.00);
    }
    @Test
    public void test_FindAllBySpecie_ShouldReturn_EmptyList_When_NoAnimals(){
    List<Animal> animals = petStore.findAllAnimalBySpecie(SPECIE);
    assertTrue(animals.isEmpty());
    }
    @Test
    public void test_FindAllBySpecie_ShouldReturn_OnlyTheRequired(){
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("Tiger",MAX_WEIGHT,PRICE));
        List<Animal> animals = petStore.findAllAnimalBySpecie(SPECIE);
        assertEquals(1,animals.size());
        assertEquals(SPECIE, animals.get(0).getSpecie());

    }
}

