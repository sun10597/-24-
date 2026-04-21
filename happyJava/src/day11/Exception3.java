package day11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception3 {
    public static void main(String[] args) throws FileNotFoundException {
        ExceptionObj1 exceptionObj1 = new ExceptionObj1();
        int value = exceptionObj1.divide(10,0);
        System.out.println(value);

        FileInputStream fileInputStream = new FileInputStream("abc");
    }

}
class ExceptionObj3{
    public int divide(int i, int j){
        int value=0;
        value = i / j;
        return value;
    }
}
