package DataStructuresWorkshop.Exc;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(0);
        list.addFirst(7);
        list.addFirst(5);
        list.addFirst(3);
        list.removeFirst();
        list.removeLast();
        list.addLast(6);
        list.forEach(System.out::println);
    }
}
