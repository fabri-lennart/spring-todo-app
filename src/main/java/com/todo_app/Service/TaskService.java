package com.todo_app.Service;

import com.todo_app.Model.Task;
import com.todo_app.Enum.CategoryType;
import com.todo_app.Enum.State;
import com.todo_app.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    // Método search CORREGIDO
    public List<Task> search(String name, String categoryStr, String stateStr) {
        // Si todos los parámetros están vacíos, retornar todas las tareas
        if ((name == null || name.trim().isEmpty()) &&
                (categoryStr == null || categoryStr.trim().isEmpty()) &&
                (stateStr == null || stateStr.trim().isEmpty())) {
            return findAll();
        }

        try {
            // Convertir strings a enums
            CategoryType category = null;
            State state = null;

            if (categoryStr != null && !categoryStr.trim().isEmpty()) {
                category = CategoryType.valueOf(categoryStr.trim());
            }

            if (stateStr != null && !stateStr.trim().isEmpty()) {
                state = State.valueOf(stateStr.trim());
            }

            return taskRepository.findByFilters(
                    (name != null && !name.trim().isEmpty()) ? name.trim() : null,
                    category,
                    state
            );
        } catch (IllegalArgumentException e) {
            // Si hay error en la conversión de enum, retornar lista vacía
            System.out.println("Error en búsqueda: " + e.getMessage());
            return List.of();
        }
    }
}