package day07;

public class ex2 {
    public static void sum100() {
        System.out.println("===1~100합===");
        int num = 0;
        for (int i = 0; i < 100; i++) {
            num += i;
        }
        System.out.println(num);
    }

    public static void gugudan() {
        System.out.println("===구구단===");
        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d * %d = %d\t", j, i, j * i);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        sum100();
        gugudan();
    }
}