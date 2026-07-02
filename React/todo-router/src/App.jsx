import { useState } from "react";
import "./App.css"
import About from "./pages/About";
import Home from "./pages/Home";
import TodoDetail from "./pages/TodoDetail";
import TodoList from "./pages/TodoList";

import { Routes, Route } from 'react-router-dom';

function App(){
  const [todos, setTodos] = useState([
  { id:1, text:"공부하기", completed:true },
  { id:2, text:"밥 먹기", completed:true },
  { id:3, text:"게임하기", completed:false },
  { id:4, text:"산책하기", completed:false }])

  //추가
  const createTodo = (text) => {
    const newTodo = {
      id: Data.now(),
      text,
      completed: false
    };
    setTodos([newTodo, ...todos]);
  };

  //삭제
  const deleteTodo = (id) => {
    setTodos(todos.filter((todo) => todo.id !== id));
  };


  //수정
  const toggleTodo = (id) => {
    setTodos(todos.map((todo) => todo.id === id ? {...todo, completed: !todo.completed} : todo));
  };
  
  return(
    <div>
      <h1>Todo App with Router</h1>
      <Routes>
        <Route path="/" element={<TodoList todos={todos} createTodo={createTodo}/>}/>
        <Route path="/todos/:id" element={
          <TodoDetail todos={todos} deleteTodo={deleteTodo} toggleTodo={toggleTodo}/>}/> 
        <Route path="/home" element={<Home/>}/>
        <Route path="/about" element={<About/>}/>
      </Routes>
    </div>
  );
}

export default App;