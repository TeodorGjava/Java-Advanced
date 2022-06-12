package Generics;

import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> list){
        return list.stream().min(T::compareTo)
                .orElseThrow(()->new IllegalArgumentException("No elements"));
    }
    public static <T extends Comparable<T>> T getMax(List<T> list){
        return list.stream().max(T::compareTo)
                .orElseThrow(()->new IllegalArgumentException("No elements"));
    }
}
