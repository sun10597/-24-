package day20.multiThreadExam1;

import java.util.Random;

public class IncrementCounter implements Runnable{

    @Override
    public void run() {
        Random random = new Random();
        for(int i=1; i<=100; i++){
            System.out.println("Increment : " + i);
            try{
                Thread.sleep(random.nextInt(11));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
