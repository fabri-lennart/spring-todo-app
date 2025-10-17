package com.todo_app.Controller;

import com.todo_app.Model.Task;
import com.todo_app.Model.User;
import com.todo_app.Service.TaskService;
import com.todo_app.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    // ==========================
    // Mostrar formulario (nuevo o editar)
    // ==========================
    @GetMapping("/form")
    public String taskForm(@RequestParam(required = false) Long id, Model model) {
        Task task;
        if (id != null) {
            task = taskService.findById(id);
            if (task == null) {
                task = new Task();
            }
        } else {
            task = new Task();
        }
        model.addAttribute("task", task);
        return "fragments/task-form :: task-form";
    }

    // ==========================
    // Guardar tarea (POST)
    // ==========================
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task, Model model) {
        // Si es una nueva tarea (sin ID), establecer fecha de creación
        if (task.getId() == null) {
            task.setCreatedDate(LocalDateTime.now());
        } else {
            // Si es edición, mantener la fecha de creación original
            Task existingTask = taskService.findById(task.getId());
            if (existingTask != null) {
                task.setCreatedDate(existingTask.getCreatedDate());
            }
        }

        if (task.getUser() == null) {
            User user = userService.findById(1L);
            task.setUser(user);
        }

        taskService.save(task);
        model.addAttribute("tasks", taskService.findAll());
        return "fragments/task-list :: task-list";
    }

    // ==========================
    // Listar tareas
    // ==========================
    @GetMapping("/list")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "fragments/task-list :: task-list";
    }

    // ==========================
    // Buscar tareas (CORREGIDO)
    // ==========================
    @GetMapping("/search")
    public String searchTasks(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String category,
                              @RequestParam(required = false) String state,
                              Model model) {
        model.addAttribute("tasks", taskService.search(name, category, state));
        return "fragments/search-results :: search-results";
    }

    // ==========================
    // ELIMINAR TAREA
    // ==========================
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id, Model model) {
        taskService.deleteById(id);
        model.addAttribute("tasks", taskService.findAll());
        return "fragments/task-list :: task-list";
    }

    // ==========================
    // ACTUALIZAR ESTADO
    // ==========================
    @PutMapping("/update-state/{id}")
    public String updateTaskState(@PathVariable Long id,
                                  @RequestParam String state,
                                  Model model) {
        Task task = taskService.findById(id);
        if (task != null) {
            task.setState(com.todo_app.Enum.State.valueOf(state));
            taskService.save(task);
        }
        model.addAttribute("tasks", taskService.findAll());
        return "fragments/task-list :: task-list";
    }
}