package Advanced.SetsAndMapsAdvanced.exc;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class countSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        TreeMap<Character,Integer> map= new TreeMap<>();
        for (int i = 0; i <arr.length() ; i++) {
            char ch = arr.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch)+1);
            }
        }
map.forEach((k,v)->{
    System.out.printf("%c: %s time/s%n",k,v);
});


    }
}
