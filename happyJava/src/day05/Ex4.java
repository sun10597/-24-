package day05;

public class Ex4 {
    public static void main(String[] args) {
        int[][] arr = new int[9][9];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                arr[i][j] = (i+1) * (j+1);
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("%d단\t\t\t", i+1);
        }
        System.out.println();
        for(int j = 0; j < 9; j++) {
            for(int i = 0; i < 9; i++) {
                System.out.printf("%d * %d = %2d\t", i+1, j+1, arr[i][j]);
            }
            System.out.println();
        }
//    실습 4: 2차원 배열 - 구구단 표
//2차원 배열을 사용하여 구구단(2단~9단)을 저장하고 출력하세요.
    }
}
