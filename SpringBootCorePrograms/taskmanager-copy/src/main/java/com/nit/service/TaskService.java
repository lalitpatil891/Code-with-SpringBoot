package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.model.Task;
import com.nit.repository.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository taskRepository;

	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	 public List<Task> createTasks(List<Task> tasks) {
	        return taskRepository.saveAll(tasks);
	    }
	
	public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

	public Optional<Task> updateTask(Long id, Task updatedTask) {
		return taskRepository.findById(id).map(task -> {
			task.setTitle(updatedTask.getTitle());
			task.setDescription(updatedTask.getDescription());
			task.setStatus(updatedTask.getStatus());
			task.setDueDate(updatedTask.getDueDate());
			return taskRepository.save(task);
		});
	}

	public boolean deleteTask(Long id) {
		return taskRepository.findById(id).map(task -> {
			taskRepository.delete(task);
			return true;
		}).orElse(false);
	}

}
