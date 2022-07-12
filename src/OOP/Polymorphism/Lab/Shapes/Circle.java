package OOP.Polymorphism.Lab.Shapes;

public class Circle extends Shape{
    private Double radius;

    @Override
    Double calculatePerimeter() {
        return 2*Math.PI*radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    Double calculateArea() {
        return Math.PI*Math.pow(radius,2);
    }
}
