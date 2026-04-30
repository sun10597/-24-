package day21;

@FunctionalInterface
interface Plus{
    int plus(int i, int j);
}
interface Func{
    int i = 1;
}

class FuncImpl implements Func{

}
public class LambdaExam1 {
    public static void main(String[] args) {
        Plus plus = (i , j) -> i + j;
        System.out.println(plus.plus(1,2));

        Runnable r  = () ->{
            System.out.println("test");
        };
        r.run();

//        Func f = () ->{
//
//        };


    }
}
