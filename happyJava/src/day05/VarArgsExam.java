package day05;

public class VarArgsExam {
    public static void printInfo(String name, int... scores) {
        System.out.print(name + "의 점수: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println("(총 " + scores.length + "과목)");
    }
    public static void main(String[] args){
        printInfo("김선우", 12, 34, 56);
    }
}

