package day10;

import java.util.Calendar;
import java.util.Scanner;

public class MyCalender {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("연도를 입력하세요");
        int year = scanner.nextInt();

        System.out.println("월을 입력하세요");
        int month = scanner.nextInt();

        printCalendar(year, month);
        scanner.close();
    }

    public static void printCalendar(int year, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        int lastDay = calendar.getActualMaximum(Calendar.DATE);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println("\n\t --- " + year + "년 " + month + "월 ---");
        System.out.println(" 일\t 월\t 화\t 수\t 목\t 금\t 토");
        System.out.println("---------------------------");

        for (int i = 1; i < startDay; i++) {
            System.out.print("\t");
        }

        for (int i = 1; i <= lastDay; i++) {
            System.out.printf("%3d\t", i);

            if ((i + (startDay - 1)) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();

    }
}
