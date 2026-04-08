package day04;

public class ForExam2 {
    public static void main(String[] args){
        for(int i=1; i<10; i++) {
            System.err.printf("%d단\t\t\t", i);
        }
        System.out.println();
        for(int i=1; i<10; i++){
            for(int j=1; j<10; j++){
                System.out.printf("%d * %d = %2d\t",j,i,i*j);
            }
            System.out.println();
        }
    }
}
