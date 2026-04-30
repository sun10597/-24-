package day22;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Student {
    private String name;
    private Map<String, Integer> scores;

    public Student(String name, Map<String, Integer> scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }


    public double getAvgScore(){
        return scores.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public String getGrade() {
        double avg = getAvgScore();
        if (avg >= 90) return "A";
        if (avg >= 80) return "B";
        if (avg >= 70) return "C";
        return "D";
    }
    @Override
    public String toString() {
        return String.format("%s(평균:%.1f)", name, getAvgScore());
    }
}

public class GradeProcessor {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("김철수", Map.of("수학", 90, "영어", 85)),
                new Student("이영희", Map.of("수학", 100, "영어", 95)),
                new Student("박민수", Map.of("수학", 70, "영어", 60)),
                new Student("최지우", Map.of("수학", 80, "영어", 88))
        );

        System.out.println("평균 점수가 80점 이상인 학생 찾기");
        students.stream()
                .filter(s -> s.getAvgScore() >= 80)
                .forEach(s -> System.out.println(s.getName() + s.getScores()));

        System.out.println();
        System.out.println("과목별 최고 점수 구하기");
        Map<String, Integer> maxScoreBySubject = students.stream()
                .flatMap(s -> s.getScores().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::max
                ));
        maxScoreBySubject.forEach((subject, score) -> System.out.println(subject + score));

        System.out.println();
        System.out.println("전체 학생의 평균 점수 계산");
        double avg = students.stream()
                        .mapToDouble(Student::getAvgScore)
                                .average()
                                        .orElse(0.0);
        System.out.println(avg);

        System.out.println();
        System.out.println("학생을 등급별로 분류 (A: 90이상, B: 80-89, C: 70-79, D: 70미만)");
        Map<String, List<Student>> byGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));
        byGrade.forEach((grade, list) -> System.out.println(grade + list));
    }
}