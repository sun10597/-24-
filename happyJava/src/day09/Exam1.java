package day09;

class MyObject{
    int i;
    @Override
    public String toString(){
        return "MyObject";
    }
}
public class Exam1 {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        myObject.toString();


        System.out.println(myObject);
        System.out.println(myObject.toString());
        System.out.println();
    }
}
