package lion.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertExam {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "lion";
        String paasword = "lion1234";
        conn = DriverManager.getConnection(url, user, paasword);
        try {
            if (conn != null) {
                System.out.println("연결됨(Connected)");
            }
        } catch (Exception e) {
            System.out.println("연결 실패: " + e.getMessage());
        }

        String sql = "insert into member(name, email, password) values(?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "aaa");
        ps.setString(2, "aaa@naver.com");
        ps.setString(3, "aaa");
        int insertCount = ps.executeUpdate();
        System.out.println(insertCount + "건 입력됨");
    }

}
