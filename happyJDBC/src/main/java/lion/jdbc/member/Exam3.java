package lion.jdbc.member;

import java.util.Scanner;

public class Exam3 {
    public static void main(String[] args) {
        MemberDAO dao = new MemberDAO();
        MemberDTO dto = new MemberDTO();

        Scanner sc = new Scanner(System.in);
        System.out.println("삭제하고 싶은 계정을 입력하세요");
        dto.setEmail(sc.nextLine());

        int resultFlag = dao.deleteMember(dto);
        if(resultFlag > 0){
            System.out.println("성공");
        }else {
            System.out.println("실패");
        }

    }
}
