package jdbc03;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeptDaoImpl implements DeptDao{
    private final JdbcTemplate jdbcTemplate;

    public DeptDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int insertDept(Dept dept) {
        String sql = "insert into dept(dname,loc) values(?,?)";
        return jdbcTemplate.update(sql, dept.getDName(), dept.getLoc());
    }

    @Override
    public List<Dept> findAllDept() {
        String sql = "select * from dept";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dept.class));
    }

    @Override
    public Dept findDeptById(int id) {
        String sql ="select * from dept where deptno = ?";
        try{
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Dept.class), id);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void updateDept(Dept dept) {
        String sql = "update dept set dname = ?, loc = ? where deptno = ?";
        jdbcTemplate.update(sql, dept.getDName(), dept.getLoc(), dept.getDeptNo());
    }

    @Override
    public void deleteDept(int id) {
        String sql = "delete from dept where deptno = ?";
        jdbcTemplate.update(sql, id);
    }
}
