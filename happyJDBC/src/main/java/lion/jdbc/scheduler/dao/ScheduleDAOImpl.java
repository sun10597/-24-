package lion.jdbc.scheduler.dao;

import lion.jdbc.Conn;
import lion.jdbc.scheduler.Scheduler;
import lion.jdbc.scheduler.dto.ScheduleDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO{

    @Override
    public int insert(ScheduleDTO dto) throws SQLException {
        String sql = "insert into schedule(title, content, start_at, end_at, category_id) values(?, ?, ?, ?, ?)";
        try(Connection conn = Conn.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getContent());
            ps.setObject(3, dto.getStartAt());
            ps.setObject(4, dto.getEndAt());
            ps.setInt(5, dto.getCategoryId());

            return ps.executeUpdate();
        }
    }

    @Override
    public ScheduleDTO findById(int id) throws SQLException {
        String sql = "Select * from schedule where schedule_id = ?";
        try (Connection conn = Conn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    ScheduleDTO dto = new ScheduleDTO();
                    dto.setScheduleId(rs.getInt("schedule_id"));
                    dto.setTitle(rs.getString("title"));
                    dto.setContent(rs.getString("content"));
                    dto.setStartAt(rs.getObject("start_at", LocalDateTime.class));
                    dto.setEndAt(rs.getObject("end_at", LocalDateTime.class));
                    dto.setStatus(rs.getString("status"));
                    dto.setCategoryId(rs.getInt("category_id"));
                    dto.setCreatedAt(rs.getObject("created_at", LocalDateTime.class));

                    return dto;
                }
            }
        }
        return null;
    }

    @Override
    public List<ScheduleDTO> findAll() throws SQLException {
        String sql = "select schedule_id, title, status, start_at from schedule";
        List<ScheduleDTO> list = new ArrayList<>();
        try(Connection conn = Conn.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                ScheduleDTO dto = new ScheduleDTO();
                dto.setScheduleId(rs.getInt("schedule_id"));
                dto.setTitle(rs.getString("title"));
                dto.setStatus(rs.getString("status"));
                dto.setStartAt(rs.getObject("start_at", LocalDateTime.class));

                list.add(dto);
            }
        }
        return list;
    }

    @Override
    public int updateStatus(int id, String status) throws SQLException {
        String sql = "update schedule set status = ? where schedule_id = ?";
        try(Connection conn = Conn.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, status);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql = "delete from schedule where schedule_id = ?";
        try(Connection conn = Conn.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}
