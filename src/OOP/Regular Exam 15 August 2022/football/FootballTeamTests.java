package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FootballTeamTests {
    Footballer footballer1;
    Footballer footballer2;
    FootballTeam team;
    private List<Footballer> footballers;

    @Before
    public void setUp() {
        this.footballers = new ArrayList<>();
        footballer1 = new Footballer("Diego Maradona");
        footballer1 = new Footballer("Kiro Kosmonavta");
        team = new FootballTeam("Durvari", 3);
        team.addFootballer(footballer1);
        team.addFootballer(footballer2);
    }

    @Test
    public void test_addFootballerMethod() {
        footballers.add(footballer1);
        Assert.assertEquals(1, footballers.size());
    }

    @Test
    public void test_DeleteFootballerMethodFromList() {
        footballers.add(footballer1);
        Assert.assertEquals(1, footballers.size());
        Assert.assertTrue(footballers.remove(footballer1));
    }

    @Test
    public void test_getCount() {
        boolean getCount = team.getCount() == 2;
        Assert.assertTrue(getCount);
    }

    @Test
    public void test_SetVacantPositions_Valid() {
        FootballTeam testTeam = new FootballTeam("Test", 2);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_Null() {
        FootballTeam noNamers = new FootballTeam(null, 8);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_WhiteSpace() {
        FootballTeam noNamers = new FootballTeam("           ", 8);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_Empty() {
        FootballTeam noNamers = new FootballTeam("", 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_Positions_BelowZero() {
        FootballTeam noNamers = new FootballTeam("Team", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addFootballer_When_Team_Full() {
        Footballer berbo = new Footballer("D Berbatov");
        Footballer risto = new Footballer("H Stoichkov");
        team.addFootballer(berbo);
        //team is full
        team.addFootballer(risto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addFootballer_When_Footballer_Exist() {
        team.addFootballer(footballer1);
        team.addFootballer(footballer1);

    }

    @Test
    public void test_getCount_Method() {
        Assert.assertEquals(2, team.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void test_Remove_NonExisting_Footballer() {
        team.removeFootballer("Messi");
    }

    @Test
    public void test_getVacantPositions_Getter() {
        Assert.assertEquals(3, team.getVacantPositions());
    }

    @Test
    public void test_footballerForSale_Valid_Arguments() {
        boolean testActive = team.footballerForSale(footballer1.getName()).isActive();
        Assert.assertFalse(testActive);
    }

    @Test(expected = NullPointerException.class)
    public void test_footballerForSale_Exception_Case() {

        Footballer exceptionFootballer = team.footballerForSale("pesho");
    }

    @Test
    public void test_getName_Method() {
        Assert.assertEquals(team.getName(), "Durvari");
    }

    @Test(expected = NullPointerException.class)
    public void test_getStatistics_Returning_String_Test() {
        Assert.assertNotNull(team.getStatistics());
    }

    @Test
    public void test_FootballerInTeam_IsActive() {
        Assert.assertTrue(footballer1.isActive());
    }

    @Test
    public void test_FootballerInTeam_NotActiveWhenForSale() {
        team.footballerForSale(footballer1.getName());
        Assert.assertFalse(footballer1.isActive());
    }

    @Test
    public void test_set_Active_Method_Setting_Properly() {
        team.footballerForSale(footballer1.getName());
        Assert.assertFalse(footballer1.isActive());
        footballer1.setActive(true);
        Assert.assertTrue(footballer1.isActive());
    }

    @Test
    public void test_NotNullStatistics() {
        FootballTeam team2 = new FootballTeam("2", 1);
        Assert.assertEquals("The footballer  is in the team 2.", team2.getStatistics());
    }


    @Test(expected = NullPointerException.class)
    public void test_Null_FootballerRemove() {
        team.removeFootballer(null);
    }

    @Test(expected = NullPointerException.class)
    public void test_Remove_AstronautByName_Method_Returns_Correct() {
        Assert.assertEquals("Durvari", team.getName());
        FootballTeam testTeam = new FootballTeam("Test", 6);
        testTeam.addFootballer(footballer1);
        testTeam.addFootballer(footballer2);
        footballers.add(footballer1);
        footballers.add(footballer2);

        Assert.assertEquals(2, team.getCount());
        String result=null;
        if (!footballers.isEmpty()) {
             result = footballers.stream().map(Footballer::getName).collect(Collectors.joining(", "));
        }
        Assert.assertEquals("Diego Maradona, Kiro Kosmonavta", result);

    }

}
