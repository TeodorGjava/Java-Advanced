package Advanced.Algorithms;

public class demo {
    public static void main(String[] args) {

        System.out.println(power(3,5));
    }

    public static int power(int num, int pow) {
        if (pow == 1) {
            return num;
        }
        return num * power(num, pow - 1);
    }
}
