package Advanced.DataStructuresWorkshop.Exc;

public class Node {
    Node prev;
    Node next;
    int value;
    public Node(int value){
        this.value =value;
    }

    @Override
    public String toString() {
        return value +"";
    }
}
