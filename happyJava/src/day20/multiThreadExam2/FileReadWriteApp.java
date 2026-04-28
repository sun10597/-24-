package day20.multiThreadExam2;

public class FileReadWriteApp {
    public static void main(String[] args) {
        Thread reader = new Thread(new FileReaderTask());
        Thread writer = new Thread(new FileWriterTask());
        reader.start();
        writer.start();
    }
}
