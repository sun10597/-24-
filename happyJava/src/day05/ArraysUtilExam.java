package day05;

import java.util.Arrays;

public class ArraysUtilExam {
    public static void main(String[] args){
        int[] number = {5,2,8,1,9,3};

        System.out.println(Arrays.toString(number));
        System.out.println(number[1]);

        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println(Arrays.toString(filled));
    }
}
