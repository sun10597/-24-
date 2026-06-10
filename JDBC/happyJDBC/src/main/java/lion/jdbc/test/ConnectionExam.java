package lion.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionExam {
    public static void main(String[] args) throws Exception{
        //1. DB접속 => connection
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "lion";
        String paasword = "lion1234";
        conn = DriverManager.getConnection(url,user,paasword);

        //수동
        conn.setAutoCommit(false);

        try {
            if (conn != null) {
                System.out.println("연결됨(Connected)");
            }
        } catch (Exception e) {
            System.out.println("연결 실패: " + e.getMessage());
        }

        //2.쿼리작성

        //3.쿼리실행
        conn.commit();
//        conn.rollback();


    }
}
