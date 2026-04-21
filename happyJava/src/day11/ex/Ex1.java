package day11.ex;

import java.util.Scanner;

class DivisionCalculator{
    public double divide(double num1, double num2) throws ArithmeticException{
        if(num2 == 0){
            throw new ArithmeticException("0으로 나눌수 없습니다.");
        }
        return num1/num2;
    }
}
public class Ex1 {
    public static void main(String[] args) {
        DivisionCalculator calc = new DivisionCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 나눗셈 계산기 ===");

        // TODO: 숫자가 아닌 입력에 대한 예외 처리 추가
        System.out.print("첫 번째 숫자를 입력하세요: ");
        double num1 = scanner.nextDouble();

        System.out.print("두 번째 숫자를 입력하세요: ");
        double num2 = scanner.nextDouble();

        // TODO: divide 메소드에서 발생하는 예외 처리 추가
        double result = calc.divide(num1, num2);
        System.out.println("결과: " + num1 + " ÷ " + num2 + " = " + result);

        scanner.close();
    }
}