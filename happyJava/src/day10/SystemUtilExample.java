package day10;

import java.util.Arrays;

public class SystemUtilExample {
    public static void main(String[] args) {
        // 현재 시간 (밀리초)
//        long currentMillis = System.currentTimeMillis();
//        System.out.println("현재 시간(밀리초): " + currentMillis);
//
//        // 나노초 (더 정밀한 시간 측정)
//        long nanoTime = System.nanoTime();
//        System.out.println("나노시간: " + nanoTime);
//
//        // 시간 측정 예제
//        long startTime = System.currentTimeMillis();
//        // 시간이 걸리는 작업
//        for(int i = 0; i < 1000000; i++) {
//            Math.sqrt(i);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("실행 시간: " + (endTime - startTime) + "ms");

        // 시스템 프로퍼티
        System.out.println("Java 버전: " + System.getProperty("java.version"));
        System.out.println("OS: " + System.getProperty("os.name"));
        System.out.println("사용자 홈: " + System.getProperty("user.home"));
        System.out.println("현재 디렉토리: " + System.getProperty("user.dir"));

        // 환경 변수
//        String path = System.getenv("PATH");
//        System.out.println("PATH: " + path);

        // 배열 복사 (native 메소드로 빠름)
//        int[] src = {1, 2, 3, 4, 5};
//        int[] dest = new int[5];
//        System.arraycopy(src, 0, dest, 0, src.length);
//        System.out.println("복사된 배열: " + Arrays.toString(dest));

        // 가비지 컬렉션 제안 (강제 실행 아님)
        System.gc();

        // 프로그램 종료
         System.exit(0); // 정상 종료
        // System.exit(1); // 비정상 종료
    }
}