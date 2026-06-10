package lion.jdbc.member;

import java.util.List;
import java.util.Scanner;

public class Exam4 {
    public static void main(String[] args) {
        MemberDAO dao = new MemberDAO();

        Scanner sc = new Scanner(System.in);
        System.out.print("조회하고 싶은 회원의 이메일을 입력하세요: ");
        String email = sc.nextLine();

        MemberDTO member = dao.selectMember(email);
        if(member != null){
        System.out.println("===== 회원 정보 조회 결과 =====");
        System.out.println("이름: " + member.getName());
        System.out.println("이메일: " + member.getEmail());
        System.out.println("가입일: " + member.getCreated());
        System.out.println("최근 수정일: " + member.getUpdated());
        System.out.println("============================");
        } else {
            System.out.println("입력하신 이메일(" + email + ")에 해당하는 회원이 없습니다.");
        }
        sc.close();
    }
}
