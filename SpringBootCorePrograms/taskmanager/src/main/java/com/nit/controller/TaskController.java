package com.nit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nit.model.Task;
import com.nit.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // principal holds authenticated username
    @GetMapping
    public List<Task> getAllTasks(Principal principal) {
        String username = principal.getName();
        return taskService.getAllTasksForUser(username);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id, Principal principal) {
        return taskService.getTaskByIdForUser(id, principal.getName())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Task createTask(@RequestBody Task task, Principal principal) {
        return taskService.createTaskForUser(task, principal.getName());
    }

    @PostMapping("/bulk")
    public List<Task> createTasks(@RequestBody List<Task> tasks, Principal principal) {
        return taskService.createTasksForUser(tasks, principal.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task, Principal principal) {
        return taskService.updateTaskForUser(id, task, principal.getName())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id, Principal principal) {
        return taskService.deleteTaskForUser(id, principal.getName())
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
