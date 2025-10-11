package com.todo_app.Service;

import com.todo_app.Model.Task;
import com.todo_app.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Guardar tarea
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    // Buscar por ID
    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // Listar todas
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    // ELIMINAR por ID - MÉTODO NUEVO
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    // Método de búsqueda
    public List<Task> search(String name, String category, String state) {
        if (name != null && name.isBlank()) name = null;
        if (category != null && category.isBlank()) category = null;
        if (state != null && state.isBlank()) state = null;

        return taskRepository.findByFilters(name, category, state);
    }
}