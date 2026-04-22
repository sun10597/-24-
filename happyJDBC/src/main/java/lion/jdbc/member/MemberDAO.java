package lion.jdbc.member;

import lion.jdbc.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    //조회
    public MemberDTO selectMember(String email){
        String sql = "select * from member where email = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, email);

            try (ResultSet result = ps.executeQuery()){
                if(result.next()){
                    MemberDTO dto = new MemberDTO();
                    dto.setName(result.getString("name"));
                    dto.setEmail(result.getString("email"));
                    dto.setPassword(result.getString("password"));
                    dto.setCreated(result.getObject("created_at", LocalDateTime.class));
                    dto.setUpdated(result.getObject("update_at", LocalDateTime.class));
                    return dto;
                }
            }
        } catch (SQLException e) {
            System.out.println("오류발생" + e.getMessage());
        }
        return null;
    }
    //입력
    public boolean insertMember(MemberDTO memberDTO) {
        String sql = "insert into member(name, email, password) values (?, ?, ?)";

        try (Connection conn = Conn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, memberDTO.getName());
            ps.setString(2, memberDTO.getEmail());
            ps.setString(3, memberDTO.getPassword());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            System.out.println("오류발생" + e.getMessage());
            return false;
        }

    }

    //수정
    public int updateMember(MemberDTO memberDTO){
        String sql = "update member set password = ? where email = ?";
        try(Connection conn = Conn.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, memberDTO.getPassword());
            ps.setString(2, memberDTO.getEmail());
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            System.out.println("오류발생" + e.getMessage());
            return 0;
        }
    }

    //삭제
    public int deleteMember(MemberDTO memberDTO){
        String sql = "delete from member where email = ?";
        try(Connection conn = Conn.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, memberDTO.getEmail());
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            System.out.println("오류발생" + e.getMessage());
            return 0;
        }
    }

    //리스트조회
    public List<MemberDTO> getMembers(){
        List<MemberDTO> members = new ArrayList<>();
        String sql = "select * from member";
        try(Connection conn = Conn.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                MemberDTO dto = new MemberDTO();

                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setEmail(rs.getString("email"));
                dto.setPassword(rs.getString("password"));
                dto.setCreated(rs.getObject("created_at", LocalDateTime.class));
                dto.setUpdated(rs.getObject("update_at", LocalDateTime.class));

                members.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("오류발생 " + e.getMessage());
        }
        return members;
    }
}