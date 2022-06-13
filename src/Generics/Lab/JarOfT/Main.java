package Generics.Lab.JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();
        jar.add(3);
        jar.add(5);
        jar.add(7);
        jar.remove();
        System.out.println();
    }


}
