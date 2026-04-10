package day07;

    class Parent{
        int a,b;
        Parent(){
            int a = 1;
            int b = 2;
            System.out.println("Parent();");
        }
    }

    class Child extends Parent{
        int a,b;
        Child(){
            int a = 3;
            int b = 4;
            System.out.println("Child():");
        }
    }
public class ParentChildExam {
    public static void main(String[] args) {
        Parent result = new Child();
        System.out.printf("%d, %d", result.a, result.b);
    }
}
