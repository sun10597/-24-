package day19;

import java.io.*;

public class IOExam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String msg = null;

        System.out.println("안녕");
        msg = br.readLine();

        System.out.println(msg);

//        while((msg = br.readLine()) != null){
//            System.out.println(msg);
//        }
        br.close();

        InputStream in = new FileInputStream("src/day19/input.txt");
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br2 = new BufferedReader(isr);

        System.out.println(br2);
    }
}
