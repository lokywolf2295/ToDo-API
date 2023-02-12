package com.sacavix.todoapp.persistence.repository;

import com.sacavix.todoapp.persistence.entity.Task;
import com.sacavix.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface TastkRepository extends JpaRepository<Task, Long> { //<nombre de la entidad, tipo del identificador que marcamos con @id>

    /**
     * Allows you to search for items by their status
     * @param status to check the status of the task
     * @return list task
     */
    public List<Task> findAllByTaskStatus(TaskStatus status);

    /**
     * Update task to status (true or false)
     * @param id recibe el ide para pasarlo a la query nativa
     */
    @Modifying //demuestra que la query es de actualización
    @Query(value = "UPDATE TASK SET FINISHED=true WHERE ID=:id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}
