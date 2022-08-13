package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.BeverageRepositoryImpl;
import restaurant.repositories.HealthFoodRepositoryImpl;
import restaurant.repositories.TableRepositoryImpl;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private static double totalmoney = 0;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository,
                          TableRepository<Table> tableRepository) {
        this.healthFoodRepository = new HealthFoodRepositoryImpl();
        this.beverageRepository = new BeverageRepositoryImpl();
        this.tableRepository = new TableRepositoryImpl();
    }


    @Override
    public String addHealthyFood(String type, double price, String name) {
        Food food = null;
        switch (type) {
            case "Salad":
                food = new Salad(name, price);
                break;
            case "VeganBiscuits":
                food = new VeganBiscuits(name, price);
                break;
        }
        if (healthFoodRepository.getAllEntities().contains(food)) {
            throw new IllegalArgumentException(FOOD_EXIST);
        } else {
            healthFoodRepository.add(food);
        }
        return String.format(FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage = null;
        switch (type) {
            case "Fresh":
                beverage = new Fresh(name, counter, brand);
                break;
            case "Smoothie":
                beverage = new Smoothie(type, counter, brand);
                break;
        }
        if (beverageRepository.beverageByName(name, brand) == null) {
            beverageRepository.add(beverage);
        } else {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }
        return String.format(BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;
        switch (type) {
            case "InGarden":
                table = new InGarden(tableNumber, capacity);
                break;
            case "Indoors":
                table = new Indoors(tableNumber, capacity);
                break;
        }
        boolean tableExists = tableRepository.byNumber(tableNumber) != null;
        if (tableExists) {
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, tableNumber));
        }
        tableRepository.add(table);
        return String.format(TABLE_EXIST, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = tableRepository.getAllEntities().stream().filter(x -> x.getSize() >= numberOfPeople &&
                !x.isReservedTable()).findFirst().orElse(null);
        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        HealthyFood food = healthFoodRepository.getAllEntities()
                .stream().filter(f -> f.getName().equals(healthyFoodName))
                .findFirst()
                .orElse(null);
        if (food == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }


    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        Beverages beverages = beverageRepository.beverageByName(name, brand);

        if (beverages == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);
        double bill = table.bill();
        totalmoney+=bill;
        table.clear();
        return String.format(BILL, table.getTableNumber(), bill);
    }


    @Override
    public String totalMoney() {

        return String.format(TOTAL_MONEY, totalmoney);
    }
}
