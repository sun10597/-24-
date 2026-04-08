package day04;

public class Exam {
    public static void main(String[] args){
        int i = 0;
        while(i++<20){
            if (i%2==0)
                continue;
            System.out.println(i);
        }
    }
}
