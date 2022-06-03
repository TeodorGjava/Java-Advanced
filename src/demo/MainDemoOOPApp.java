package demo;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainDemoOOPApp {


    public static void main(String[] args) {
//        Concrete zames1
        Map<String,Double> materials = new LinkedHashMap<>();
        materials.put("neshto",500.);
        Concrete zames1 = new Concrete("client","20/20/2020",10,10,20,materials);
        System.out.println(zames1.getMaterials());
    }
}
