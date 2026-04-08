package day04;

import java.util.Scanner;

public class StringExam {
    public static void main(String[] args){
        System.out.println("숫자를 입력하세요");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int a = Integer.parseInt(args[0]);
        for(int i=0; i<input; i++){
            System.out.print("hello");
        }
    }
}
