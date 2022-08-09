package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.CarRepository;
import christmasRaces.repositories.DriverRepository;
import christmasRaces.repositories.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.CAR_CREATED;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;


    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        //Creates a Driver with the given name and adds it to the appropriate repository.
        //The method should return the following message:
        //"Driver {name} is created."
        //If a driver with the given name already exists in the driver repository, throw an IllegalArgumentException with a message:
        //"Driver {name} is already created."
        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }
        Driver driverToAdd = new DriverImpl(driver);
        driverRepository.add(driverToAdd);
        return String.format("Driver %s is created.", driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        //Create a Car with the provided model and horsepower and add it to the repository.
        // There are two types of Car: "MuscleCar" and "SportsCar".
        //The command will be in the following format: "CreateCar {"Muscle"/"Sports"} {model} {name}".
        //If the Car already exists in the appropriate repository throw an IllegalArgumentException
        // with the following message:
        //"Car {model} is already created."
        //If the Car is successfully created, the method should return the following message:
        //"{"MuscleCar"/ "SportsCar"} {model} is created."
        Car car = carRepository.getByName(model);
        String typeCar = null;

        if (car != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        if (type.equals("Muscle")) {
            typeCar = "MuscleCar";
            car = new MuscleCar(model, horsePower);
        }
        if (type.equals("Sports")) {
            typeCar = "SportsCar";
            car = new SportsCar(model, horsePower);
        }
        carRepository.add(car);
        return String.format(CAR_CREATED, typeCar, model);

    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        Car car = carRepository.getByName(carModel);
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        driver.addCar(car);
        return String.format("Driver %s received car %s.", driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Driver driver = driverRepository.getByName(driverName);
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (driver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        if (driver.getCanParticipate()) {
            race.addDriver(driver);
        }else{
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE,driverName));
        }
        return String.format("Driver %s added in %s race.", driverName, raceName);
    }


    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
        raceRepository.add(new RaceImpl(name, laps));
        return String.format("Race %s is created.", name);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (race.getDrivers().stream().filter(Driver::getCanParticipate).count() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        List<Driver> drivers = race.getDrivers()
                .stream()
                .sorted((driver1, driver2) -> Double.compare(driver2.getCar().calculateRacePoints(race.getLaps()),
                        driver1.getCar().calculateRacePoints(race.getLaps()))).collect(Collectors.toList());

        return String.format("Driver %s wins %s race.%n" +
                        "Driver %s is second in %s race.%n" +
                        "Driver %s is third in %s race.%n",
                drivers.get(0).getName(), raceName,
                drivers.get(1).getName(), raceName,
                drivers.get(2).getName(), raceName);
    }
}
