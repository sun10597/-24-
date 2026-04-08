package day04;

public class LabelExam {
    public static void main(String[] args){
        outter:
        for(int i = 0; i < 3; i++){
            for(int k = 0; k < 3; k++){
                if(i == 0 && k == 2)
                    break outter; // 바깥쪽 반복문까지 종료
                System.out.println(i + ", " + k);
            }
        }
    }
}
