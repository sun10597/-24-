package day03;

//놀이기구 탑승 조건은 나이(age)가 15세 이상이고, 키(height)가 140cm 이상이어야 합니다. 두 조건을 모두 만족하는지 판별하여 true 또는 false를 출력하는 코드를 작성하세요.

public class OperatorPractice3 {
    public static void main(String[] args) {
        int age = 14;
        int height = 150;

        // 비교 연산자와 논리 연산자를 사용하여 탑승 가능 여부(boolean)를 출력하세요.
        System.out.println(age>=15 && height>=140);
    }
}