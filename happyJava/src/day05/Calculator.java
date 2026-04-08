package day05;

public class Calculator {
    public static int add(int i, int j){
        return i + j;
    }

    public static int a(int... numbers){
        int sum = 0;
        for(int num : numbers){
            sum += num;
        }
        return sum;
    }
    public static void main(String[] args){
        int sumResult = Calculator.add(10,20);
        System.out.println(sumResult);

        int sumResult2 = Calculator.a(1,2,3,4,5);
        System.out.println(sumResult2);

    }
}
