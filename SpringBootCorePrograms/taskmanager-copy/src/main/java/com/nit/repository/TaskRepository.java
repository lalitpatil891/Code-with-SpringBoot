package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
}
