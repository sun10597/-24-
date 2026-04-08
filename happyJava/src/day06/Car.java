package day06;

public class Car { // 클래스명은 의미 있는 명사로 (예: Car)
    // 1. 캡슐화를 위해 private 권장
    private String color;

    // 2. 생성자
    public Car(String color) {
        this.color = color;
        System.out.println("생성자가 호출되어 " + this.color + " 자동차가 생성되었습니다.");
    }

    // 3. 필드 값을 외부에서 안전하게 가져오기 위한 Getter
    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        // 인스턴스 생성 (이 시점에 생성자가 실행됨)
        Car myCar = new Car("파랑");

        // 생성된 객체의 변수 출력
        System.out.println("내 차의 색상: " + myCar.getColor());
    }
}