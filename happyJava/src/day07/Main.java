package day07;

public class Main {
    static class A{
        static  String nu(){
            return "A";
        }
        String mo(){
            return "a";
        }
    }
    static  class B extends A{
        static String nu(){
            return "B";
        }
        String mo(){
            return "b";
        }
    }

    public static void main(String[] args) {
        A test = new B();
        System.out.println(test.nu() + test.mo());
    }
}
