package day07;

import java.util.Scanner;

public class ex1 {
    static Scanner sc = new Scanner(System.in);

    public static void number(){
        System.out.println("정수를 입력하세요");
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println(num + ": 짝수입니다");
        } else {
            System.out.println(num + ": 홀수입니다");
        }

    }

    public static void Max(){
        System.out.println("세 개의 정수를 입력해주세요");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        System.out.println("가장 큰 수: " + max);
    }
    public static void main(String[] args) {
        number();
        Max();
    }
}
