package day20;

//쓰레드를 생성하는 2가지 방법 - 1. 상속  2. 구현
class MyThread extends Thread {
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        이 쓰레드에서 하고자 하는 일은 run() 에 구현함!!
        for(int i = 0; i < 10; i++){
            System.out.println("안녕");
        }
    }
}
public class TreadExam {
    public static void main(String[] args) {
        System.out.println("main start!!!");

        MyThread t1 = new MyThread();
        t1.start();  //Thread를 시작 시키는 메서드는 start();



        for(int i = 0; i < 10; i++){
            System.out.println("main이 일하고 있음. ");
        }

        System.out.println("main end!!!");


    }
}