package day06;

public class Smartphone {
    String brand;
    String model;
    int batteryLevel;

    public void checkBattery(){
        System.out.printf("현재 배터리 잔량은 %d%% 입니다\n", batteryLevel);
    }

    public void charge(){
        batteryLevel+=10;
        System.out.println("충전중... 배터리가 10% 증가했습니다.");

    }

    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();
        smartphone.brand = "Samsung";
        smartphone.model = "S24+";
        smartphone.batteryLevel = 80;

        smartphone.checkBattery();
        smartphone.charge();
        smartphone.checkBattery();
    }
}
