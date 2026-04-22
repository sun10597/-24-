package lion.jdbc.member;

import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        MemberDTO dto = new MemberDTO();
        MemberDAO dao = new MemberDAO();

        Scanner sc = new Scanner(System.in);
        System.out.println("본인 이메일을 입력하세요.");
        dto.setEmail(sc.nextLine());
        System.out.println("변경하고 싶은 비밀번호를 입력하세요");
        dto.setPassword(sc.nextLine());

        int resultFlag = dao.updateMember(dto);

        if(resultFlag > 0){
            System.out.println("성공");
        }else {
            System.out.println("실패");
        }

    }
}
