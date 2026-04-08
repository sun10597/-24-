package day05;

public class EX2 {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int max = arr[0];
        int min = arr[0];

        for (int i=0; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.printf("최대값: %d\n최소값: %d", max, min);
    }

//    실습 2: 최대값과 최소값 찾기
//    정수 배열에서 최대값과 최소값을 찾는 프로그램을 작성하세요.

}
