package DefiningClasses.Exc.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    private String name;
    Car car;
    Company company;
    List<Parents> parents;
    List<Pokemon> pokemon;
    List<Children> children;


    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }

    public List<Children> getChildren() {
        return children;
    }

    public void addChildren(Children children) {
        this.children.add(children);
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void addParents(Parents parents) {
        this.parents.add(parents);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public Person() {
        this.parents = new ArrayList<>();
        this.pokemon= new ArrayList<>();
        this.children = new ArrayList<>();
    }

}

class Children {
    String childName;
    String childBirthday;

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public String getChildBirthday() {
        return childBirthday;
    }

    public void setChildBirthday(String childBirthday) {
        this.childBirthday = childBirthday;
    }
}

class Parents {
    String parent;
    String parentBirthday;

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParentBirthday() {
        return parentBirthday;
    }

    public Parents(String parent, String parentBirthday) {
        this.parent = parent;
        this.parentBirthday = parentBirthday;
    }

    public void setParentBirthday(String parentBirthday) {
        this.parentBirthday = parentBirthday;
    }
}

class Company {
    public Company(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    String companyName;
    String department;
    double salary;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Car {
    String model;

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    String speed;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}

class Pokemon {
    String pokemonName;
    String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }
}
