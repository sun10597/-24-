package day22;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exam1 {
    public static void main(String[] args) {
        int[] iarr = {1, 2, 3, 4, 5 };
        IntStream step1 = Arrays.stream(iarr);

        IntStream step2 = step1.filter(i -> {
            System.out.println("filter 실행");
            return i % 2 == 0;
        });

        System.out.println("filter 결과");
        step2.forEach(System.out::println);
    }
}
