package OOP.Inheritance.Lab;

public class Main {
    public static void main(String[] args) {
        RandomArrayList rnd = new RandomArrayList();
        rnd.add("1");
        rnd.add("2");
        rnd.add("3");
        rnd.add("7");
        System.out.println(rnd.getRandomElement());
    }
}
