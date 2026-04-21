package day11;

public class Exception1 {
    public static void main(String[] args) {
        ExceptionObj1 exceptionObj1 = new ExceptionObj1();
        int value = exceptionObj1.divide(10,0);
        System.out.println(value);
    }

}
class ExceptionObj1{
    public int divide(int i, int j){
        int value=0;
        try {
            value = i / j;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            value=i;
        }
        return value;
    }
}
