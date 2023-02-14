package com.sacavix.todoapp.service;

import com.sacavix.todoapp.exceptions.ToDoExceptions;
import com.sacavix.todoapp.mapper.TaskInDTOToTask;
import com.sacavix.todoapp.persistence.entity.Task;
import com.sacavix.todoapp.persistence.entity.TaskStatus;
import com.sacavix.todoapp.persistence.repository.TastkRepository;
import com.sacavix.todoapp.service.dto.TaskInDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //le dice al contenedor bin de spring, que cree un bin y lo guarde en ese contenedor, para luego ser identado donde se lo necesite
public class TaskService {

    //en el service va toda la lógica necesaria para el programa.
    private final TastkRepository repository;
    private final TaskInDTOToTask mapper;

    //Constructor crea la Inyexión por dependencia
    public TaskService(TastkRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //Crea la tarea
    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    //muestra la lista de tareas
    public List<Task> findAll() {
        return this.repository.findAll();
    }

    //muestra la lista de tareas segun su estado
    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    //actualiza el estado de la tarea
    @Transactional
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) { //si no hay taréa
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
       this.repository.markTaskAsFinished(id);
    }

    //elimina el task mediante su id
    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }

}
