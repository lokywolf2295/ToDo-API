package com.sacavix.todoapp.service;

import com.sacavix.todoapp.mapper.TaskInDTOToTask;
import com.sacavix.todoapp.persistence.entity.Task;
import com.sacavix.todoapp.persistence.repository.TastkRepository;
import com.sacavix.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

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

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }
}
