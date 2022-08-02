package OOP.Reflection.Exercises.RichSoilLand;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    private final static String END_COMMAND = "HARVEST";
    private final static Scanner SCAN = new Scanner(System.in);
    private final static String PUBLIC = "public";
    private final static String PROTECTED = "protected";
    private final static String PRIVATE = "private";
    private final static String OUTPUT = "%s %s %s%n";//access modifier, field type, field name;
private final static Field[] declaredFields = RichSoilLand.class.getDeclaredFields();

    public static void main(String[] args) {
        String input;
        while (!END_COMMAND.equals(input = SCAN.nextLine())) {
            switch (input) {
                case PRIVATE:
                    filterFieldsByModifier(PRIVATE);

                    break;
                case PUBLIC:
                    filterFieldsByModifier(PUBLIC);
                    break;
                case PROTECTED:
                    filterFieldsByModifier(PROTECTED);
                    break;
                case "all":
                    Arrays.stream(declaredFields).forEach(getFieldConsumer());

            }
        }
        SCAN.close();

    }
    private static void filterFieldsByModifier( String modifier){
        Arrays.stream(declaredFields).
                filter(s -> Modifier.toString(s.getModifiers()).equals(modifier)).
                forEach(getFieldConsumer());
    }
    private static Consumer<Field> getFieldConsumer(){
        return field -> System.out.printf(OUTPUT,Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),field.getName());
    }
}
