package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Task;
import com.nit.model.User;
import com.nit.repository.TaskRepository;
import com.nit.repository.UserRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    // Get all tasks for a given username
    public List<Task> getAllTasksForUser(String username) {
        return taskRepository.findByUserUsername(username);
    }

    // Create a task for a user
    public Task createTaskForUser(Task task, String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        task.setUser(user);
        return taskRepository.save(task);
    }

    // Bulk create tasks for user
    public List<Task> createTasksForUser(List<Task> tasks, String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        for (Task t : tasks) t.setUser(user);
        return taskRepository.saveAll(tasks);
    }

    public Optional<Task> getTaskByIdForUser(Long id, String username) {
        return taskRepository.findByIdAndUserUsername(id, username);
    }

    public Optional<Task> updateTaskForUser(Long id, Task updatedTask, String username) {
        return taskRepository.findByIdAndUserUsername(id, username).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            task.setDueDate(updatedTask.getDueDate());
            return taskRepository.save(task);
        });
    }

    public boolean deleteTaskForUser(Long id, String username) {
        return taskRepository.findByIdAndUserUsername(id, username).map(task -> {
            taskRepository.delete(task);
            return true;
        }).orElse(false);
    }
}
