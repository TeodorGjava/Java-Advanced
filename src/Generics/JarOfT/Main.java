package Generics.JarOfT;

public class Main {
    public static void main(String[] args) {
        Generics.Jar<Integer> jar = new Generics.Jar<>();
        jar.add(3);
        jar.add(5);
        jar.add(7);
        jar.remove();
        System.out.println();
    }


}
