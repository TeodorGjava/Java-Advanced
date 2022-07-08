package OOP.Encapsulation.Exercises.BoxClass;

public class Box {
    //-	length: double
    //-	width:  double
    //-	height:  double
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    private void checkArgument(double arg,String type){
        if(arg<=0){
            throw new IllegalArgumentException(type+" cannot be zero ot negative");
        }
    }
    private void setLength(double length){
        checkArgument(length,"Length");
    }
    private void setWidth(double width){
        checkArgument(width,"Width");
    }
    private void setHeight(double height){
    checkArgument(height,"Height");
    }
    public double calculateSurfaceArea(){
        //2lh + 2wh
        return 2*(length*height+width*height+length*width);
    }
    public double calculateVolume(){
        return length*width*height;
    }
    public double calculateLateralSurfaceArea(){
        return 2*(length*height+width*height);
    }
}
