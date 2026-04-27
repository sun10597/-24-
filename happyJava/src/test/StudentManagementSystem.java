package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Student{
    private static int count = 0;

    private int id;
    private String studentId;
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa){
        this.id = ++count;
        this.studentId = studentId();
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public Student(String name){
        this(name, 18, 0.0);
    }

    private String studentId() {
        String headId = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        return headId + String.format("%04d", this.id);
    }

    public void updateAge(int age){
        if(age>=18 && age<=100){
            this.age = age;
            System.out.println(name + " 학생의 나이가 " + age + "세로 수정되었습니다.");
        }else {
            System.out.println("학생 나이는 성인이여야 합니다.");
        }
    }

    public void updateGpa(double gpa){
        if (gpa >= 0.0 && gpa <= 4.0){
            this.gpa = gpa;
            System.out.println(name + " 학생의 GPA가 " + gpa + "로 수정되었습니다.");
        }else{
            System.out.println("GPA는 0.0 - 4.0 사이여야 합니다.");
        }
    }
    public boolean isExellent(){
        return this.gpa >= 3.5;
    }

    public void displayInfo(){
        System.out.println("--------------------");
        System.out.println("학번: " + studentId);
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("학점: " + gpa);
        if (isExellent()){
            System.out.println("우수학생");
        }
        System.out.println("--------------------");
        System.out.println();
    }
}
public class StudentManagementSystem {
    public static void main(String[] args) {
        System.out.println("==== 학생 정보 관리 시스템 ====");
        List<Student> students = new ArrayList<>();

        students.add(new Student("김선우", 25, 3.9));
        students.add(new Student("김민지"));
        students.add(new Student("이민", 20, 3.5));

        for (Student s : students) {
            if(s.getName().equals("김민지")){
                s.updateAge(22);
                s.updateGpa(3.3F);
            }
        }
            for (Student s : students){
            s.displayInfo();
        }

//        Student student = new Student("김선우", 25, 3.5);
//        Student s1 = new Student("김선우");
//        student.displayInfo();
//        s1.displayInfo();
//
//        s1.updateAge(20);
//        s1.displayInfo();
    }
}
