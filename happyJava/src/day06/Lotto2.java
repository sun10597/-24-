package day06;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Lotto2 {
    // 1. 상수 정의: 무엇을 의미하는지 한눈에 알 수 있음
    private static final int LOTTO_SIZE = 6;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private final List<Integer> numbers = new ArrayList<>();

    public void generate() {
        // 2. Set을 활용한 자동 중복 제거 (Modern Java 방식)
        Set<Integer> lottoSet = new HashSet<>();

        while (lottoSet.size() < LOTTO_SIZE) {
            lottoSet.add(ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1));
        }

        // 3. 정렬 및 리스트 저장
        this.numbers.clear();
        this.numbers.addAll(lottoSet);
        Collections.sort(this.numbers);
    }

    // 4. Getter를 통해 읽기 전용으로 제공 (캡슐화)
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "이번 주 행운의 번호: " + numbers;
    }

    public static void main(String[] args) {
        Lotto2 lotto = new Lotto2();
        lotto.generate();
        System.out.println(lotto);
    }
}