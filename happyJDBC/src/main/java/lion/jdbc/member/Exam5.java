package lion.jdbc.member;

import java.util.List;

public class Exam5 {
    public static void main(String[] args) {
        MemberDAO dao = new MemberDAO();
        List<MemberDTO> memberList = dao.getMembers();
        for(MemberDTO member : memberList){
            System.out.println(member);
        }
    }
}
