package com.sacavix.todoapp.persistence.repository;

import com.sacavix.todoapp.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TastkRepository extends JpaRepository<Task, Long> { //<nombre de la entidad, tipo del identificador que marcamos con @id>


}
