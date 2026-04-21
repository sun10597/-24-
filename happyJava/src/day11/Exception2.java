package day11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception2 {
    public static void main(String[] args) {
        ExceptionObj1 exceptionObj1 = new ExceptionObj1();
        int value = exceptionObj1.divide(10,0);
        System.out.println(value);
    }

}
class ExceptionObj2{
    public int divide(int i, int j) throws Exception{
        int value=0;
        value = i / j;
        return value;
    }
}
