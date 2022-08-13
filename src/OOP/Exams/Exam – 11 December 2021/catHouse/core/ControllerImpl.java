package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.BaseHouse;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;

import java.util.List;


import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private List<House> houses;
    private static final String SHORTCAT_HOUSEHOLD = "ShortHouse";
    private static final String LONGCAT_HOUSEHOLD = "LongHouse";

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);

        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        House house = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        Toy toy = toys.findFirst(toyType);
        if (toy != null && house != null) {
            house.buyToy(toy);
            toys.removeToy(toy);
        } else {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        House house = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        if (house != null) {
            if (house.getClass().getSimpleName().equals(SHORTCAT_HOUSEHOLD) && catType.equals("ShorthairCat")
                    ||
                    house.getClass().getSimpleName().equals(LONGCAT_HOUSEHOLD) && catType.equals("LonghairCat")) {
                house.addCat(cat);
                return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, house.getName());
            }
        }
        return UNSUITABLE_HOUSE;
    }

    @Override
    public String feedingCat(String houseName) {
        House house = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);

        house.getCats().forEach(Cat::eating);
        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        double catsPrice = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double toysPrice = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        return String.format(VALUE_HOUSE, houseName, catsPrice + toysPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder str = new StringBuilder();
        for (House house : houses
        ) {
            str.append(house.getStatistics())
                    .append(System.lineSeparator());
        }
        return str.toString().trim();
    }
}
