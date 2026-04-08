package day05;

import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] rev = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        System.out.println(Arrays.toString(rev));

//    실습 3: 배열 뒤집기
//    주어진 배열의 요소 순서를 뒤집는 프로그램을 작성하세요.

    }
}
