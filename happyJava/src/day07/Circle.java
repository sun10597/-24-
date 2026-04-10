package day07;

public class Circle {
    private double i;
    private static double pi = 3.14;

    public Circle(double i){
        this.i=i;
    }
    public double area(){
        return i * i * pi;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.printf("원의 면적: %.1f", circle.area());
    }
}
