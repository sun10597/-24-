package com.example.todoapp.service;

import com.example.todoapp.dto.TodoDto;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import com.example.todoapp.repository.TodoRepository;
import com.example.todoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public TodoDto.Response createTodo(Long userId, TodoDto.CreateRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        Todo todo = Todo.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(user)
                .completed(false)
                .build();

        Todo savedTodo = todoRepository.save(todo);
        return TodoDto.Response.fromEntity(savedTodo);
    }

    public List<TodoDto.Response> getAllTodos(Long userId){
        return todoRepository.findByUserId(userId).stream()
                .map(TodoDto.Response::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public TodoDto.Response toggleComplete(Long userId, Long id){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 할 일이 존재하지 않습니다."));

        todo.setCompleted(!todo.isCompleted());
        return TodoDto.Response.fromEntity(todo);
    }

    @Transactional
    public void deleteTodo(Long userId, Long id){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 할 일이 존재하지 않습니다."));

        todoRepository.delete(todo);
    }
}
