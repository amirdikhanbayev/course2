package com.example.demo.service;

import com.example.demo.model.Task1;
import com.example.demo.repository.Task1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private Task1Repository task1Repository;

    @Override
    public Task1 createTask(Task1 task1){
        return task1Repository.save(task1);
    }
    @Override
    public void deleteTask(Long id){
        task1Repository.deleteById(id);
    }
    @Override
    public Optional<Task1> changeTask(Long id, String task){
        //сделать изменение задачи
        return null;
    }
    @Override
    public Optional<Task1> changeStId(Long id, Long student_id){
        //сделать изменение student_id
        return null;
    }
//    @Override
//    public void MakeTrue(Long id){
//        task1Repository.MakeAsDone(id);
//    }
//    @Override
//    public void  MakeFalse(Long id){
//        task1Repository.MakeAsFalse(id);
//    }
}
