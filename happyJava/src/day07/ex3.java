package day07;

import java.util.Scanner;

public class ex3 {
    static Scanner sc = new Scanner(System.in);

    public static void MaxMin() {
        System.out.println("===배열===");
        System.out.println("정수 5개를 입력하세요:");
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }
        int max = nums[0];
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.printf("최대값: %d\n최소값: %d\n", max, min);
    }

    public static void fruitSearch() {
        System.out.println("===과일 배열===");
        String[] fruits = {"사과", "바나나", "딸기", "포도"};
        System.out.println("찾고 싶은 과일을 입력하세요");

        Scanner fr = new Scanner(System.in);
        String search = fr.nextLine();

        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i].equals(search)) {
                System.out.println(search + "는 있습니다");
                return;
            }
        }
        System.out.println("해당 과일은 존재하지 않습니다");
    }

    public static void main(String[] args) {
        MaxMin();
        fruitSearch();
    }
}
