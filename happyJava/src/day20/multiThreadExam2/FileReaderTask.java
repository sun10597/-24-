package day20.multiThreadExam2;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTask implements Runnable{
    @Override
    public void run() {
        try(FileReader reader = new FileReader(
                "src/day20/multiThreadExam2/input.txt")){
            int a;
            System.out.println("=== input.txt ===");
            while((a = reader.read()) != -1){
                System.out.print((char) a);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());        }
    }
}
