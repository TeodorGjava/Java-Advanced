package OOP.Polymorphism.Lab.Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }

    abstract Double calculatePerimeter();
    abstract Double calculateArea();

}
