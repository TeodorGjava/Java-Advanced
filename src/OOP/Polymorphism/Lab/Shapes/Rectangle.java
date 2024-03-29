package OOP.Polymorphism.Lab.Shapes;

public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    Double calculatePerimeter() {
        return (height+width)*2;
    }

    @Override
    Double calculateArea() {
        return height*width;
    }
}
