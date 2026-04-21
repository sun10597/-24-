package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DeleteExam {
    public static void main(String[] args) throws Exception{
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "lion";
        String paasword = "lion1234";
        conn = DriverManager.getConnection(url,user,paasword);
        try {
            if (conn != null) {
                System.out.println("연결됨(Connected)");
            }
        } catch (Exception e) {
            System.out.println("연결 실패: " + e.getMessage());
        }


    }
}
