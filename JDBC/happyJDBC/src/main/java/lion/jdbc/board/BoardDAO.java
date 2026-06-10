package lion.jdbc.board;

import lion.jdbc.Conn;
import lion.jdbc.board.DTO.BoardDTO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    // 게시글 작성
    public Long writeBoard(BoardDTO board) {
        String sql = "INSERT INTO board (title, content, user_id) VALUES (?, ?, ?)";


        try (Connection conn = Conn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, board.getTitle());
            ps.setString(2, board.getContent());
            ps.setString(3, board.getUserId());

            int count = ps.executeUpdate();
            if (count > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // 페이징된 게시글 목록
    public List<BoardDTO> getBoardList(int page, int size) {
        String sql = "SELECT b.*, u.name as author_name " +
                "FROM board b " +
                "INNER JOIN user u ON b.user_id = u.user_id " +
                "ORDER BY b.board_id DESC " +
                "LIMIT ?, ?";

        List<BoardDTO> boards = new ArrayList<>();
        int offset = (page - 1) * size;

        try (Connection conn = Conn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, offset);
            ps.setInt(2, size);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BoardDTO board = new BoardDTO();
                    board.setBoardId(rs.getInt("board_id"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setUserId(rs.getString("user_id"));
                    board.setAuthorName(rs.getString("author_name"));
                    board.setRegdate(rs.getObject("regdate", LocalDateTime.class));
                    board.setViewCnt(rs.getInt("view_cnt"));
                    boards.add(board);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return boards;
    }

    // 게시글 조회 (조회수 증가 포함)
    public BoardDTO getBoard(Long boardId) {
        BoardDTO board = null;
        Connection conn = null;

        try {
            conn = Conn.getConnection();
            conn.setAutoCommit(false);

            // 조회
            String selectSql = "SELECT b.*, u.name as author_name " +
                    "FROM board b " +
                    "INNER JOIN user u ON b.user_id = u.user_id " +
                    "WHERE b.board_id = ?";

            try (PreparedStatement ps = conn.prepareStatement(selectSql)) {
                ps.setLong(1, boardId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        board = new BoardDTO();
                        board.setBoardId(rs.getInt("board_id"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setUserId(rs.getString("user_id"));
                        board.setAuthorName(rs.getString("author_name"));
                        board.setRegdate(rs.getObject("regdate", LocalDateTime.class));
                        board.setViewCnt(rs.getInt("view_cnt"));
                    }
                }
            }

            // 조회수 증가
            if (board != null) {
                String updateSql = "UPDATE board SET view_cnt = view_cnt + 1 " +
                        "WHERE board_id = ?";
                try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                    ps.setLong(1, boardId);
                    ps.executeUpdate();
                }
            }

            conn.commit();

        } catch (SQLException e) {
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) {}
            }
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {}
            }
        }

        return board;
    }
}