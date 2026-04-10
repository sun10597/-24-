package day08.absstractClassEx;

abstract class Shape{
    abstract double getArea();
    abstract double getPerimeter();
}

class Rectangle extends Shape{
    private double width;
    private double height;
    Rectangle(double width, double height){
        this.width = width ;
        this.height = height;
    }
    @Override
    double getArea(){
        return width * height;
    }
    @Override
    double getPerimeter(){
        return 2 *(width + height);
    }
}

class Circle extends Shape{
    private double radius;
    Circle(double radius){
        this.radius = radius;
    }
    @Override
    double getArea(){
        return Math.PI * radius *radius;
    }
    @Override
    double getPerimeter(){
        return 2 * Math.PI * radius;
    }
}
public class Ex2 {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle(5,5),
                new Circle(5)
        };

        for(Shape s : shapes){
            String shape = s.getClass().getSimpleName();
            System.out.println(shape + " - Perimeter: " + s.getPerimeter() + ", Area: " + s.getArea());
        }
    }
}
