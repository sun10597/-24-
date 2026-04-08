package day04;

public class WhileExam {
    public static void main(String[] args){
        int i=0;

//        while(i++<100){
//            System.out.println(i);
//        }

        int a=0;
        int b=0;
        while(i++<100){
            if(i%2==0){
                a+=i;
            }else{
                b+=i;
            }
        }
        System.out.printf("짝수의합 %d\n홀수의합 %d",a,b);
    }
}
