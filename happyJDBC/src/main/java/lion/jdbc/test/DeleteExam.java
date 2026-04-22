package lion.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

        String sql = "DELETE FROM member WHERE email = ?";
        PreparedStatement psDelete = conn.prepareStatement(sql);
        psDelete.setString(1, "aaa@naver.com");
        int deleteCount = psDelete.executeUpdate();
        System.out.println(deleteCount + "건 삭제됨");
    }
}
