package day07;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ex4 {
    static Scanner sc = new Scanner(System.in);
    public static void Score(){
        int[] scores = new int[5];
        int sum = 0;
        double avg = 0;
        int count = 0;

        for(int i=0; i<scores.length; i++){
            System.out.println("학생 점수를 입력해주세요 " + (i+1));
            scores[i] = sc.nextInt();
            sum += scores[i];
            if(scores[i]>=60){
                count++;
            }
        }
        avg = (double) sum/5;

        int max = scores[0];
        for(int score : scores){
            if(score > max){
                max = score;
            }
        }

        System.out.println("전체 평균: " + avg);
        System.out.println("최고 점수: " + max);
        System.out.println("60점 이상 학생 수: " + count + "명");
    }

    public static void NumberGame() {
        int num = new Random().nextInt(100) + 1;
        int input;
        System.out.println("1~100 사이의 숫자를 맞춰보세요!");

        while (true) {
            System.out.print("입력: ");
            input = sc.nextInt();

            if (input > num) {
                System.out.println(input + "보다 작다");
            } else if (input < num) {
                System.out.println(input + "보다 크다");
            } else {
                System.out.println("정답!");
                break;
            }
        }
    }

    public static void LottoGame() {
        int[] lotto = new int[6];

        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = new Random().nextInt(45) + 1;

            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(lotto);

        System.out.println("로또 번호: " + Arrays.toString(lotto));
    }

    public static void main(String[] args) {
        Score();
        NumberGame();
        LottoGame();
    }
}
