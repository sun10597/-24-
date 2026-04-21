package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Person{
    private String id;
    private String name;
    private int age;

    public Person(String name, int age){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
    }
}

public class Exam {
    public static void main(String[] args) {
//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person("김선우", 25));
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.get(0));
    }
}
