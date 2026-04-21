package day10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MathUtilExample {
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static int[] generateLotto() {
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size() < 6) {
            numbers.add((int)(Math.random() * 45) + 1);
        }
//        return numbers.stream().sorted().mapToInt(i -> i).toArray();
        int[] arr = new int[6];
        int index = 0;
        for(int num : numbers){
            arr[index++] = num;
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("거리: " + distance(0, 0, 3, 4)); // 5.0
        System.out.println("로또: " + Arrays.toString(generateLotto()));
    }
}