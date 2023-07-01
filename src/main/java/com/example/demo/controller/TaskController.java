package com.example.demo.controller;

import com.example.demo.model.Task1;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Task1 create(@RequestBody Task1 task1){
        return taskService.createTask(task1);
    }
    @GetMapping("/deleteTask")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PutMapping("/changeTask/{id}/{task}")
    public Optional<Task1> changeT(@PathVariable Long id, @PathVariable String task){
        return taskService.changeTask(id,task);
    }
    @PutMapping("/changeStId/{id}/{student_id}")
    public Optional<Task1> changeStId(@PathVariable Long id, @PathVariable Long student_id){
        return taskService.changeStId(id,student_id);
    }
    @GetMapping("/getAll")
    public List<Task1> getAllTask(){
        return taskService.getCurrentUserTasks();
    }
    @PutMapping("/makeDone")
    public void done(@PathVariable Long id){
        taskService.MakeTrue(id);
    }
    @PutMapping("/makeFalse")
    public void unfulfilled(@PathVariable Long id){
        taskService.MakeFalse(id);
    }
}
