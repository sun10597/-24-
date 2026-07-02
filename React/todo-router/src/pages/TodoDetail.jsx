import { useParams, useNavigate } from "react-router-dom";

function TodoDetail({ todos, deleteTodo, toggleTodo }) {
  const { id } = useParams(); // URL에서 :id 값 가져오기
  const navigate = useNavigate(); // 페이지 이동을 위한 훅

  // URL 파라미터(id)는 문자열이므로 숫자로 변환 후 데이터 찾기
  const todo = todos.find((t) => t.id === Number(id));

  // 해당 todo가 없을 경우 예외 처리
  if (!todo) {
    return <div>해당 할 일을 찾을 수 없습니다.</div>;
  }

  const handleDelete = () => {
    deleteTodo(todo.id);
    navigate("/"); // 삭제 후 목록 페이지로 이동
  };

  return (
    <div>
      <h2>할 일 상세 정보</h2>
      <p><strong>번호:</strong> {todo.id}</p>
      <p><strong>내용:</strong> {todo.text}</p>
      <p><strong>상태:</strong> {todo.completed ? "완료됨" : "진행 중"}</p>

      {/* 완료 상태 토글 버튼 */}
      <button onClick={() => toggleTodo(todo.id)}>
        {todo.completed ? "미완료로 변경" : "완료로 변경"}
      </button>

      {/* 삭제 버튼 */}
      <button onClick={handleDelete} style={{ marginLeft: "10px", color: "red" }}>
        삭제
      </button>

      {/* 목록으로 돌아가기 */}
      <button onClick={() => navigate("/")} style={{ marginLeft: "10px" }}>
        목록으로
      </button>
    </div>
  );
}

export default TodoDetail;