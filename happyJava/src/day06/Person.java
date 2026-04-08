package day06;

public class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public static void main(String[] args) {
        Person person = new Person("김선우",26,"서울 구로");
        System.out.println(person.name);
    }
}
