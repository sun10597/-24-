package lion.jdbc.scheduler.dao;

import lion.jdbc.scheduler.dto.ScheduleDTO;

import java.sql.SQLException;
import java.util.List;

public interface ScheduleDAO {
    int insert(ScheduleDTO dto) throws SQLException;

    ScheduleDTO findById(int id) throws SQLException;

    List<ScheduleDTO> findAll() throws SQLException;

    int updateStatus(int id, String status)throws SQLException;

    int delete(int id)throws SQLException;
}
