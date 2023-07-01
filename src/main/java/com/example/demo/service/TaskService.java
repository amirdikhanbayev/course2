package com.example.demo.service;

import com.example.demo.model.Task1;
import com.example.demo.model.User1;

import java.util.Optional;

public interface TaskService {
    Task1 createTask(Task1 task1);

    void deleteTask(Long id);

    Optional<Task1> changeTask(Long id, String task);

    Optional<Task1> changeStId(Long id, Long student_id);

    //void MakeTrue(Long id);

    //void  MakeFalse(Long id);
}
