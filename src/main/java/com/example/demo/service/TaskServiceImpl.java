package com.example.demo.service;

import com.example.demo.model.Task1;
import com.example.demo.model.User1;
import com.example.demo.repository.Task1Repository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private Task1Repository task1Repository;
    @Autowired
    private UserService userService;

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
        Task1 old = task1Repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException());
        old.setTask(task);
        return Optional.of(task1Repository.save(old));
    }
    @Override
    public Optional<Task1> changeStId(Long id, Long student_id){
        Task1 old = task1Repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException());
        old.setStudentId(student_id);
        return Optional.of(task1Repository.save(old));
    }
    @Override
    public List<Task1> getCurrentUserTasks() {
        return task1Repository.findByStudentId(userService.getCurrentUser().getId());}
    @Override
    public void MakeTrue(Long id){
        task1Repository.MakeAsDone(id);
    }
    @Override
    public void MakeFalse(Long id){
        task1Repository.MakeAsFalse(id);
    }
}
