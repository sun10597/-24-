package day03;

public class IfElseIfPractice1 {
    public static void main(String[] args) {
//        int dust = 75; // 미세먼지 수치
//        for(int i=0; i<args.length; i++){
//            System.err.printf("%d\t", Integer.parseInt(args[i]));
//        }
//        if(args.length > 0) {
//            int dust = Integer.parseInt(args[4]);

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                int dust = Integer.parseInt(args[i]);

                System.out.printf("미세먼지 수치: %d → ", dust);

                // if-else if문을 사용하여 미세먼지 상태를 출력하세요.
                // 조건 1: 30 이하이면 "좋음"
                // 조건 2: 80 이하이면 "보통"
                // 조건 3: 150 이하이면 "나쁨"
                // 그 외 (151 이상): "매우 나쁨"
                // 여기에 코드를 작성하세요.
                if (dust <= 30) {
                    System.out.println("좋음");
                } else if (dust <= 80) {
                    System.out.println("보통");
                } else if (dust <= 150) {
                    System.out.println("나쁨");
                } else {
                    System.out.println("매우나쁨");
                }


            }
        }
    }
}