package com.example.todo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
        
import com.example.todo.todo.entity.todoEntity;

@Repository
public interface todoRepository extends JpaRepository<todoEntity, Long> {

    
} 