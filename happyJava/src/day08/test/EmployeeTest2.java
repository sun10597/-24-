package day08.test;

import day08.Employee;

public class EmployeeTest2 extends Employee {
    public void test(){
        department="";
        position="";
    }

    public static void main(String[] args) {
        EmployeeTest2 employeeTest2 = new EmployeeTest2();
        employeeTest2.department="";
    }
}
