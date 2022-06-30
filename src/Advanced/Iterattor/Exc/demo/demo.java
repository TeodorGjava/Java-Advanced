package Advanced.Iterattor.Exc.demo;

import java.util.Iterator;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        demoCollection demo = new demoCollection("arg","arg2","ag3","and so on");
    }
     class Itterator implements Iterator<String> {
        int index = 0;
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public String next() {
           return null;
        }
    }
}
