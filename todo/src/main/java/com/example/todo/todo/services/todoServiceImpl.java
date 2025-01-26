package com.example.todo.todo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todo.todo.repository.todoRepository;
import com.example.todo.todo.model.Todo;
import com.example.todo.todo.entity.todoEntity;

@Service
public class todoServiceImpl implements todoService {

    @Autowired
    private todoRepository todoRepository;

    @Override
    public List<Todo> getTodos() {
        List<todoEntity> todos = todoRepository.findAll(); 
        List<Todo> todoDtos = new ArrayList<>();
        for (todoEntity todo : todos) {
            Todo todoDto = new Todo();
            BeanUtils.copyProperties(todo, todoDto);
            todoDtos.add(todoDto);
        }
        return todoDtos;
    }

    @Override
    public Todo createTodo(Todo todo) {
        todoEntity todoEntity = new todoEntity();   
        BeanUtils.copyProperties(todo, todoEntity);
        todoRepository.save(todoEntity);
        return todo;
    }

    @Override
    public Todo updateTodo( Long id, Todo todo) {
        todoEntity existingTodo = todoRepository.findById(id).get();
        if (existingTodo != null) {
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setCompleted(todo.isCompleted());
            todoRepository.save(existingTodo);
            return todo;
        }
        return null;    

    }

    @Override
    public void deleteTodo(Long id) {
        todoEntity existingTodo = todoRepository.findById(id).get();
        if (existingTodo != null) {
            todoRepository.deleteById(id);
        }
    }

    @Override
    public Todo getTodo(Long id) {
        todoEntity existingTodo = todoRepository.findById(id).get();
        if (existingTodo != null) {
            Todo todoDto = new Todo();
            BeanUtils.copyProperties(existingTodo, todoDto);
            return todoDto;
        }
        return null;
    }
    
}
