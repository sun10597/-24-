package lion.jdbc.board;

import lion.jdbc.board.DTO.BoardDTO;

import java.util.List;

public class Exam {
    public static void main(String[] args) {
        BoardDAO dao = new BoardDAO();

//        // 1. 게시글 작성 테스트
//        System.out.println("=== 1. 게시글 작성 시도 ===");
//        BoardDTO newBoard = new BoardDTO();
//        newBoard.setTitle("qwer1234");
//        newBoard.setContent("내용");
//        newBoard.setUserId("sunwoo"); // 반드시 user 테이블에 존재하는 ID여야 함 (INNER JOIN 때문)
//        newBoard.setAuthorName("sun");
//
//        Long generatedId = dao.writeBoard(newBoard);
//        if (generatedId != null) {
//            System.out.println("글 작성 성공! 생성된 글 번호: " + generatedId);
//        }
//
//        System.out.println();

        // 2. 목록 조회 테스트 (1페이지, 5개씩)
        System.out.println("=== 2. 게시글 목록 조회 (1페이지) ===");
        List<BoardDTO> boardList = dao.getBoardList(1, 5);
        for (BoardDTO b : boardList) {
            System.out.println(b);
        }

        System.out.println();

//        // 3. 특정 게시글 상세 조회 테스트 (조회수 증가 확인)
//        if (generatedId != null) {
//            System.out.println("=== 3. 상세 조회 및 조회수 증가 확인 ===");
//            // 첫 번째 조회
//            BoardDTO board = dao.getBoard(generatedId);
//            if (board != null) {
//                System.out.println("조회된 제목: " + board.getTitle());
//                System.out.println("현재 조회수: " + board.getViewCnt());
//            }
//
//            // 두 번째 조회 (조회수가 1 더 늘었는지 확인)
//            board = dao.getBoard(generatedId);
//            System.out.println("재조회 후 조회수: " + board.getViewCnt());
//        }

    }
}