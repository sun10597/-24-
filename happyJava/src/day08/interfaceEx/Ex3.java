package day08.interfaceEx;

interface Calculator{
    int add(int a, int b);
    int subtract(int a, int b);
}

class BasicCalculator implements Calculator{
    @Override
    public int add(int a, int b) {
        return a + b;
    }
    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}
interface Multipliable{
    int multiply(int a, int b);
}

class AdvancedCalculator implements Multipliable, Calculator{
    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
    @Override
    public int add(int a, int b) {
        return a + b;
    }
    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}
public class Ex3 {
    public static void main(String[] args) {
        Calculator c1 = new BasicCalculator();
        System.out.printf("BasicCalculaor/add: %d\n", c1.add(2,3));
        System.out.printf("BasicCalculaor/subtract: %d\n", c1.subtract(2,3));

        Calculator c2 = new AdvancedCalculator();
        System.out.println();
        System.out.printf("AdvancedCalculator/add: %d\n", c2.add(5,4));
        System.out.printf("AdvancedCalculator/subtract: %d\n", c2.subtract(5,4));

        Multipliable multipliable = new AdvancedCalculator();
        System.out.println();
        System.out.printf("AdvancedCalculator/multiply: %d\n", multipliable.multiply(2,3));
    }
}
