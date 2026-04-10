package day08;

interface TV{
    void turnOn();
    void turnOff();
}

class STV implements TV{
    @Override
    public void turnOn() {
        System.out.println("Samsung TV를 켭니다.");
    }
    @Override
    public void turnOff() {
        System.out.println("Samsung TV를 끕니다.");
    }
}

class LTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("LG TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("LG TV를 끕니다.");
    }
}

class TVFactory{
    public static TV getTV(String brand){
        if(brand.equals("S"))
            return new STV();
        if(brand.equals("L"))
            return new LTV();
        return null;
    }
}
public class Exam11 {
    public static void main(String[] args) {
        TV tv = TVFactory.getTV(args[0]);

        if (tv != null) {
            tv.turnOn();
            tv.turnOff();
        } else {
            System.out.println("해당하는 브랜드의 TV가 없습니다.");
        }
    }
}

