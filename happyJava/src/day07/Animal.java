package day07;

public class Animal {
    public void makeSound() {
        System.out.println("동물이 소리를 냅니다.");
    }

    public void move() {
        System.out.println("동물이 움직입니다.");
    }

    public static void main(String[] args) {
        
    }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("멍멍!");
    }

    @Override
    public void move() {
        System.out.println("강아지가 네 발로 뛰어다닙니다.");
    }

    // Dog만의 고유 메소드
    public void wagTail() {
        System.out.println("꼬리를 흔듭니다.");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("야옹~");
    }

    @Override
    public void move() {
        System.out.println("고양이가 살금살금 걷습니다.");
    }

    public void scratch() {
        System.out.println("할퀴기!");
    }
}