package com.sacavix.todoapp.persistence.repository;

import com.sacavix.todoapp.persistence.entity.Task;
import com.sacavix.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TastkRepository extends JpaRepository<Task, Long> { //<nombre de la entidad, tipo del identificador que marcamos con @id>

    public List<Task> findAllByTaskStatus(TaskStatus status);

}
