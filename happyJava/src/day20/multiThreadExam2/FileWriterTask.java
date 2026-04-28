package day20.multiThreadExam2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTask implements Runnable{
    @Override
    public void run() {
        try(Scanner scanner = new Scanner(System.in);
            FileWriter fileWriter = new FileWriter("src/day20/multiThreadExam2/output.txt", true)){
            System.out.println("\n=== output.txt ===");
            String input = scanner.nextLine();
            fileWriter.write(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
