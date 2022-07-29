package solid;

import java.util.List;

public class Printer {
//Single responsibility - reason for creating the class
    public void print(String format, double amount){
        System.out.printf(format,amount);
    }
}
