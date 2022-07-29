package OOP.Reflection.barracksWars.core.factories;

import OOP.Reflection.barracksWars.interfaces.Unit;
import OOP.Reflection.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    @SuppressWarnings("all")
    public Unit createUnit(String unitType) throws
            ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException {
        final Class<Unit> reflection = (Class<Unit>) Class.forName(UNITS_PACKAGE_NAME + unitType);

        return  createUnit(reflection);
    }

    private Unit createUnit(Class<Unit> unitClass) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        final Constructor<Unit> constructorOfUnit = unitClass.getDeclaredConstructor();
        constructorOfUnit.setAccessible(true);
        return constructorOfUnit.newInstance();

    }
}
