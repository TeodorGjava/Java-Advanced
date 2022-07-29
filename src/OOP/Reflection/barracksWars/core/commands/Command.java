package OOP.Reflection.barracksWars.core.commands;

import OOP.Reflection.barracksWars.interfaces.Executable;
import OOP.Reflection.barracksWars.interfaces.Repository;
import OOP.Reflection.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private final String[] data;
    private final Repository repository;
    private final UnitFactory factory;

    protected Command(String[] data, Repository repository, UnitFactory factory) {
        this.data = data;
        this.repository = repository;
        this.factory = factory;
    }

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getFactory() {
        return this.factory;
    }


}
