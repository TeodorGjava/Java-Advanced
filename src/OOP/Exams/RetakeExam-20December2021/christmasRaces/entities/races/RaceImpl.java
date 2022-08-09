package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;

import java.util.ArrayList;
import java.util.Collection;

import static christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        this.drivers = new ArrayList<>();
    }


    public void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_LAPS);
        }
        this.laps = laps;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(DRIVER_INVALID);
        }
        if (driver.getCar() == null) {
            throw new IllegalArgumentException(DRIVER_NOT_PARTICIPATE);
        }
        if (drivers.contains(driver)) {
            throw new IllegalArgumentException(DRIVER_ALREADY_ADDED);
        }
        drivers.add(driver);
    }
}
