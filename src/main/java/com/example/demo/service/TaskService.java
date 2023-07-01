package com.example.demo.service;

import com.example.demo.model.Task1;
import com.example.demo.model.User1;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task1 createTask(Task1 task1);

    void deleteTask(Long id);

    Optional<Task1> changeTask(Long id, String task);

    Optional<Task1> changeStId(Long id, Long student_id);

    List<Task1> getCurrentUserTasks();

    void MakeTrue(Long id);

    void  MakeFalse(Long id);
}
