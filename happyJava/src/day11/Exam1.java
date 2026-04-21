package day11;

public class Exam1 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3};
        try{
            System.out.println(numbers[3]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("finally!!!");
        }
        System.out.println("프로그램 종료");
    }
}
