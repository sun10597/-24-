package day08.absstractClassEx;

abstract class Animal{
    String name;
    Animal(String name){
        this.name = name;
    }

    abstract void makeSound();
    void eat(){
        System.out.println(name + "이 먹이를 먹습니다.");
    }
}

class Dog extends Animal{
    Dog(String name){
        super(name);
    }
    @Override
    void makeSound(){
        System.out.println("멍멍");
    }
}

class Cat extends Animal{
    Cat(String name){
        super(name);
    }
    @Override
    void makeSound(){
        System.out.println("야옹");
    }
}
public class ex1 {
    public static void main(String[] args) {
        Animal dog = new Dog("Dog");
        Animal cat = new Cat("Cat");
        dog.makeSound();
        dog.eat();
        cat.makeSound();
        cat.eat();
    }
}
