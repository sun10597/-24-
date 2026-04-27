package lion.jdbc.scheduler.service;

import lion.jdbc.scheduler.dao.ScheduleDAO;
import lion.jdbc.scheduler.dto.ScheduleDTO;

import java.sql.SQLException;
import java.util.List;

public interface ScheduleService {
    void insertSchedule(ScheduleDTO dto)throws SQLException;
    List<ScheduleDTO> findAll() throws SQLException;
    ScheduleDTO findById(int id) throws SQLException;
    void updateScheduleStatus(int id) throws SQLException;
    void deleteSchedule(int id) throws  SQLException;
}
