package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;

        setSize(size);
        this.setReservedTable(false);
        this.pricePerPerson = pricePerPerson;
    }

    protected void setReservedTable(boolean reservedTable) {
        this.isReservedTable = reservedTable;
    }

    protected void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    protected void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return numberOfPeople * pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (this.size >= numberOfPeople) {
            setReservedTable(true);
            setNumberOfPeople(numberOfPeople);
        }
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);

    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double sumFood = healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double sumBeverages = beverages.stream().mapToDouble(Beverages::getPrice).sum();
        return sumFood + sumBeverages + allPeople();
    }

    @Override
    public void clear() {
        healthyFood.clear();
        beverages.clear();
        setReservedTable(false);


    }

    @Override
    public String tableInformation() {
        return String.format("Table - %s%n" +
                        "Size - %s%n" +
                        "Type - %s%n" +
                        "All price - %s", this.getTableNumber(), this.getSize(), this.getClass().getSimpleName(),
                this.pricePerPerson());
    }
}
