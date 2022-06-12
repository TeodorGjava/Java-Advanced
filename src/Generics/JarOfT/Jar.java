package Generics;

import java.util.ArrayDeque;

public class Jar<E>{
    //object/element E of any kind
    public Jar(){
        this.elements = new ArrayDeque<>();
    }
    ArrayDeque<E> elements;
    public void add (E element){
        this.elements.push(element);
    }
    public E remove(){
        return elements.pop();
    }
}
