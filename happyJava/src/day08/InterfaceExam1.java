package day08;

interface TestA{
    int LEVEL = 10;
    default  void aa(){
        System.out.println("TestA의 aa()");
    }
}
interface TestB{
    default  void aa(){
        System.out.println("TestB의 aa()");
    }
}

class TestClass implements TestA, TestB{
    int i;
    static final int II=10;
    @Override
    public void aa(){
        System.out.println("TestClass의 aa()");
    }
}

public class InterfaceExam1 {
    public static void main(String[] args) {
        int Level = TestA.LEVEL;
    }
}
