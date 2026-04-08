package day05;

public class Ex1 {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        for(int i=0; i< arr.length; i++){
            if(arr[i]%2==0){
                System.out.print(arr[i]+"\t");
            }
        }
    }
//    실습 1: 배열 기본 다루기
//    길이가 10인 int형 배열을 만들고, 1~10의 값을 저장한 후 짝수만 출력하세요.


}
