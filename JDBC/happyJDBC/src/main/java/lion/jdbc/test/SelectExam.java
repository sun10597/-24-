package lion.jdbc.test;

import java.sql.*;

public class SelectExam {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "lion";
        String password = "lion1234";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            //접속
            conn = DriverManager.getConnection(url, user, password);
            //쿼리
            String sql = "select id, name, email, password from member";
            ps = conn.prepareStatement(sql);
            //실행
            rs = ps.executeQuery();


            System.out.println("id\tname\temail\tpassword");
            while (rs.next()){
                System.out.print(rs.getInt("id") + "\t");
                System.out.print(rs.getString("name") + "\t");
                System.out.print(rs.getString("email") + "\t");
                System.out.println(rs.getString("password") + "\t");
                System.out.println();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(rs!=null){
                try{
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
