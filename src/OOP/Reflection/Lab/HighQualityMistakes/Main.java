package OOP.Reflection.Lab.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class clazz = Reflection.class;

        Field[] allDeclaredFields = clazz.getDeclaredFields();

        //public Fields
        Arrays.stream(allDeclaredFields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n",field.getName()));

        Method[] allDeclaredMethods = clazz.getDeclaredMethods();
        // private getters
        Arrays.stream(allDeclaredMethods)
                .filter(method -> method.getName().startsWith("get")&&!Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be public!%n",method.getName()));

        //public setters
        Arrays.stream(allDeclaredMethods)
                .filter(method -> method.getName().startsWith("set")&&!Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be private!%n",method.getName()));
    }
}
