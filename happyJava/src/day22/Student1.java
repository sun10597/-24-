package day22;
class Students{
    String name;
    int age;
    String subject;

    public Students(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    public void Info(){
        System.out.printf("이름 : %s, 나이 : %d, 전공 : %s\n", name, age, subject);
    }
}

public class Student1 {
    public static void main(String[] args) {
        Students students = new Students("Eve", 95, "Math");
        students.Info();
    }
}
