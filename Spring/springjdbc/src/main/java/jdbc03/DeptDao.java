package jdbc03;

import java.util.List;

public interface DeptDao {
    int insertDept(Dept dept);
    List<Dept> findAllDept();
    Dept findDeptById(int id);
    void updateDept(Dept dept);
    void deleteDept(int id);
}
