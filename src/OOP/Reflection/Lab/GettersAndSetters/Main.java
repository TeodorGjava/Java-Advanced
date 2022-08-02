package OOP.Reflection.Lab.GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        //getters
        Arrays.stream(methods)
                .filter(m->m.getName().contains("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(getter->
                        System.out.printf("%s will return class %s%n",
                                getter.getName(),getter.getReturnType().getName()));
    //setters
        Arrays.stream(methods)
                .filter(m->m.getName().contains("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(setter->
                        System.out.printf("%s and will set field of class %s%n",
                                setter.getName(),setter.getParameterTypes()[0].getName()));
    }
}
