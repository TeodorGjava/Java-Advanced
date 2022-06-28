package OOP.workingWithAbstraction.pointInRect;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] cordinates = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point a = new Point(cordinates[0], cordinates[1]);
        Point c = new Point(cordinates[2], cordinates[3]);
        Rectangle rectangle = new Rectangle(a, c);

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            int[] pointCoordinates = getCoordinates(sc);
            Point x = new Point(pointCoordinates[0], pointCoordinates[1]);
            // a(x1,y1), c(x2,y2) x(x3,y3)

            //x3>=x1&&y3>=y1^^x3<=x2 && u3 <=y2
            boolean isInside=rectangle.contains(x);
            System.out.println(isInside);
        }
    }

    private static int[] getCoordinates(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
