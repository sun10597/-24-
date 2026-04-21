package lion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateExam {
    public static void main(String[] args) throws Exception {
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


        String sql = "UPDATE member SET name = ?, email = ?, password = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "김선우");
        ps.setString(2, "email.gmail.com");
        ps.setString(3, "1234");
        ps.setInt(4, 1);
        int updateCount = ps.executeUpdate();
        System.out.println(updateCount + "건 수정됨");
    }
}
