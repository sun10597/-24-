package jdbc03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = org.example.springjdbc.SpringjdbcApplication.class)
public class DeptDaoTest {

    @Autowired
    private DeptDao deptDao; // 우리가 만든 DeptDaoImpl이 자동으로 주입됩니다.

    @Test
    public void 전체_흐름_테스트() {
        // 1. 등록 (Insert) 테스트
        // deptNo는 넣지 않습니다. DB가 알아서 해줄 테니까요!
        Dept newDept = new Dept();
        newDept.setDName("개발팀");
        newDept.setLoc("서울");

        int result = deptDao.insertDept(newDept);
        System.out.println("======> 등록 결과 (영향받은 행): " + result);
        assertThat(result).isEqualTo(1); // 성공 시 1개의 행이 영향을 받아야 함


        // 2. 전체 조회 (Find All) 테스트
        List<Dept> list = deptDao.findAllDept();
        System.out.println("======> 현재 전체 부서 목록:");
        for (Dept dept : list) {
            System.out.println(dept.getDeptNo() + " | " + dept.getDName() + " | " + dept.getLoc());
        }
        assertThat(list).isNotEmpty();


        // 3. 만약 방금 넣은 부서의 번호가 1번이라고 가정하고 단건 조회 및 수정 테스트
        // (실제 데이터가 비어있던 DB라면 첫 insert라 1번일 가능성이 높습니다)
        int targetId = 1;
        Dept foundDept = deptDao.findDeptById(targetId);

        if (foundDept != null) {
            System.out.println("======> 조회된 부서: " + foundDept.getDName());

            // 수정 (Update) 테스트
            foundDept.setDName("기술지원팀");
            foundDept.setLoc("부산");
            deptDao.updateDept(foundDept);

            Dept updatedDept = deptDao.findDeptById(targetId);
            System.out.println("======> 수정 후 부서명: " + updatedDept.getDName() + ", 지역: " + updatedDept.getLoc());
            assertThat(updatedDept.getDName()).isEqualTo("기술지원팀");
        } else {
            System.out.println("======> ID " + targetId + "번 부서가 존재하지 않아 수정 테스트를 건너뜁니다.");
        }
    }
}