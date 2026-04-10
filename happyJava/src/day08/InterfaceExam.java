package day08;

interface SmartDevice {
    // 추상 메소드
    void turnOn();
    void turnOff();

    // default 메소드 (Java 8+)
    default void reset() {
        System.out.println("기본 설정으로 초기화합니다.");
        turnOff();
        turnOn();
    }

    // static 메소드 (Java 8+)
    static void showInfo() {
        System.out.println("스마트 기기 인터페이스 v1.0");
    }
}

class SmartPhone implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("스마트폰 전원 ON");
    }

    @Override
    public void turnOff() {
        System.out.println("스마트폰 전원 OFF");
    }

    // default 메소드는 오버라이딩 가능
    @Override
    public void reset() {
        System.out.println("스마트폰 공장 초기화 진행...");
        turnOff();
        turnOn();
    }
}

public class InterfaceExam{
    public static void main(String[] args) {
        SmartDevice.showInfo();
        SmartPhone smartPhone = new SmartPhone();
    }
}
