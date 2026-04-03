package day03;

public class Quiz {
    public static void main(String[] args) {

        // 1번
        System.out.println("=== 1번 ===");
        int score1 = 75;

        if (score1 >= 80) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }

        // 2번
        System.out.println("\n=== 2번 ===");
        int score2 = 90;
        char grade;

        if (score2 > 90) {
            grade = 'A';
        } else if (score2 >= 80) {
            grade = 'B';
        } else {
            grade = 'C';
        }

        System.out.println(grade);

        // 3번
        System.out.println("\n=== 3번 ===");
        int num = 2;

        switch (num) {
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Two");
            case 3:
                System.out.println("Three");
                break;
        }

        // 4번
        System.out.println("\n=== 4번 ===");
        int a1 = 10;
        String result = (a1 % 2 == 0) ? "짝수" : "홀수";
        System.out.println(result);

        // 5번
        System.out.println("\n=== 5번 ===");
        int a2 = 5;
        int b2 = 2;
        double result2 = a2 / b2;
        System.out.println(result2);

        // 6번
        System.out.println("\n=== 6번 ===");
        int x = 5;

        if (x > 10 && ++x > 0) {
            System.out.println("실행");
        }

        System.out.println(x);

        // 7번
        System.out.println("\n=== 7번 ===");
        int i = 5;

        System.out.println(i++);
        System.out.println(++i);

        // 8번
        System.out.println("\n=== 8번 ===");
        byte a3 = 10;
        byte b3 = 20;

        int result3 = a3 + b3;
        System.out.println(result3);

        // 9번
        System.out.println("\n=== 9번 ===");
        double pi = 3.141592;
        System.out.printf("%.2f%n", pi);

        // 10번
        System.out.println("\n=== 10번 ===");
        int a4 = 10;
        int b4 = 3;

        System.out.println((double) a4 / b4);
    }
}