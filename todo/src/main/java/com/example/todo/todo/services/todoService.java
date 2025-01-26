package com.example.todo.todo.services;

import java.util.List;

import com.example.todo.todo.model.Todo;

public interface todoService {
    List<Todo> getTodos();
    Todo createTodo(Todo todo); 
    Todo updateTodo(Long id, Todo todo);
    void deleteTodo(Long id);
    Todo getTodo(Long id); 
}
