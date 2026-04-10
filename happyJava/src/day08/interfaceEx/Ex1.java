package day08.interfaceEx;

interface Printer{
    void print(String message);
}
class ConsolePrinter implements Printer{
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
public class Ex1 {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        printer.print("d");
    }
}
