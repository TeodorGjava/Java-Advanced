package Advanced.Genn;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list){
        //bubble sort
        for (int i = 0; i <list.size() ; i++) {
            T currentElement = list.get(i);
            for (int j = i+1; j <list.size() ; j++) {
                if(currentElement.compareTo(list.get(j))>0){
                    list.swap(i,j);
                }
            }
        }
    }
}
