package day08;

public class Employee {
    private String name;        // 외부에서 직접 접근 불가
    private int salary;         // 외부에서 직접 접근 불가
    protected String department; // 같은 패키지와 자식 클래스에서 접근
    public String position;      // 어디서든 접근 가능

}