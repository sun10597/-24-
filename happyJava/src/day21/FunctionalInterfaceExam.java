package day21;
@FunctionalInterface
interface Function{
    int f(int i, int j);
}
public class FunctionalInterfaceExam {
    public static void main(String[] args) {
        Function plus = (i, j) -> i + j;
        Function minus = (i, j) -> i - j;
        Function multiply = (i, j) -> i * j;
        Function division= (i, j) -> i / j;

        System.out.println(plus.f(1,2));
        System.out.println(minus.f(1,2));
        System.out.println(multiply.f(3,2));
        System.out.println(division.f(4,2));
    }
}
