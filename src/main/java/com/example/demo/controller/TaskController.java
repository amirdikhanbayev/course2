package com.example.demo.controller;

import com.example.demo.model.Task1;
import com.example.demo.model.User1;
import com.example.demo.service.GetService;
import com.example.demo.service.GetServiceImpl;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private GetService getService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('TEACHER')")
    public Task1 create(@RequestBody Task1 task1){
        //done (JSON - studentId)
        return taskService.createTask(task1);
    }
    @DeleteMapping("/deleteTask/{id}")
    @PreAuthorize("hasAuthority('TEACHER')")
    //done
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PutMapping("/changeTask/{id}/{task}")
    @PreAuthorize("hasAuthority('TEACHER')")
    //done
    public Optional<Task1> changeT(@PathVariable Long id, @PathVariable String task){
        return taskService.changeTask(id,task);
    }
    @PutMapping("/changeStId/{id}/{student_id}")
    @PreAuthorize("hasAuthority('TEACHER')")
    //done
    public Optional<Task1> changeStId(@PathVariable Long id, @PathVariable Long student_id){
        return taskService.changeStId(id,student_id);
    }
    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('TEACHER')")
    //done
    public List<Task1> getAllTask(){
        return taskService.getCurrentUserTasks();
    }
    @PutMapping("/makeDone/{id}")
    @PreAuthorize("hasAuthority('STUDENT')")
    //done
    public void done(@PathVariable Long id){
        taskService.MakeTrue(id);
    }
    @PutMapping("/makeFalse/{id}")
    @PreAuthorize("hasAuthority('TEACHER')")
    //done
    public void unfulfilled(@PathVariable Long id){
        taskService.MakeFalse(id);
    }
}

//docker log out
