package lion.jdbc.scheduler.service;

import lion.jdbc.scheduler.dao.ScheduleDAO;
import lion.jdbc.scheduler.dao.ScheduleDAOImpl;
import lion.jdbc.scheduler.dto.ScheduleDTO;

import java.sql.SQLException;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleDAO dao = new ScheduleDAOImpl();
    @Override
    public void insertSchedule(ScheduleDTO dto) throws SQLException {
        if (dto.getEndAt().isBefore(dto.getStartAt())) {
            System.out.println("종료 시간이 시작 시간 보다 빠를수 없습니다.");
        }
        dao.insert(dto);
    }

    @Override
    public List<ScheduleDTO> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public ScheduleDTO findById(int id) throws SQLException {
        ScheduleDTO dto = dao.findById(id);
        if(dto != null){
            System.out.println(id + "번 일정을 찾을수 없습니다.");
        }
        return dto;
    }

    @Override
    public void updateScheduleStatus(int id) throws SQLException {
        dao.updateStatus(id, "완료");
    }

    @Override
    public void deleteSchedule(int id) throws SQLException {
        dao.delete(id);
    }
}
