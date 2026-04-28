package day20.multiThreadExam1;

public class CounterApp {
    public static void main(String[] args) {
        Thread incrementThread = new Thread(new IncrementCounter());
        Thread decrementThread = new Thread(new Decrementcounter());

        incrementThread.start();
        decrementThread.start();
    }
}