package DataStructuresWorkshop;

public class SmartArray {
    private int[] elements;
    private int nextIndex = 0;

    public SmartArray() {
        this.elements = new int[4];
    }

    public void add(int element) {
        //if index is out of bounds
        if(this.nextIndex==this.elements.length){
            this.elements = expand();
        }
        elements[nextIndex] = element;
        nextIndex++;
    }
    //recreating the array in new Array with +1 size
    //allocating new memory for the new +1 element Arr
    private int[] expand(){
        int[] newArray = new int[this.elements.length*2];
        //transferring the elements to the new Arr
        for (int i = 0; i <this.elements.length ; i++) {
            newArray[i]=this.elements[i];
        }
        return newArray;
    }
}
