package day07;

public class Rectangle {
    private double width;
    private double heigh;

    public Rectangle(double width, double heigh){
        this.width = width;
        this.heigh = heigh;

    }

    public double area(){
        return heigh * width;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3,4);
        System.out.printf("사각형의 면적: %.1f\n", rectangle.area());
    }
}
