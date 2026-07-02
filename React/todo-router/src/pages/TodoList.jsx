import { useState } from "react";
import { Link } from "react-router-dom";
import MyComponent from "../component/MyComponent";

function TodoList({ todos, createTodo }) {
  const [text, setText] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!text.trim()) return; // 빈 입력 방지
    createTodo(text);
    setText(""); // 입력창 초기화
  };

  return (
    <div>
        <MyComponent/>
      <h2>할 일 목록</h2>
      
      {/* 등록 폼 */}
      <form onSubmit={handleSubmit}>
        <input 
          type="text" 
          value={text} 
          onChange={(e) => setText(e.target.value)} 
          placeholder="할 일을 입력하세요"
        />
        <button type="submit">추가</button>
      </form>

      {/* 목록 출력 */}
      <ul>
        {todos.map((todo) => (
          <li key={todo.id}>
            {/* 상세 페이지로 이동하는 링크 */}
            <Link to={`/todos/${todo.id}`} style={{ textDecoration: todo.completed ? "line-through" : "none" }}>
              {todo.text}
            </Link>
            {todo.completed ? " (완료)" : " (미완료)"}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TodoList;