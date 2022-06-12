package Generics;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("A","B");
        System.out.println(scale.getHeavier());
        Scale<Integer> scale1 = new Scale<>(16,745);
    }
}
