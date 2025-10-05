package com.todo_app.Controller;

import com.todo_app.Model.Task;
import com.todo_app.Model.User;
import com.todo_app.Service.TaskService;
import com.todo_app.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService; // Para asignar un usuario a la tarea

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
                task = new Task(); // si no existe, crear uno nuevo
            }
        } else {
            task = new Task(); // nuevo
        }
        model.addAttribute("task", task);
        return "fragments/task-form :: task-form";
    }

    // ==========================
    // Guardar tarea (POST)
    // ==========================
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task, Model model) {
        // Si no se asigna usuario desde login, podemos usar un usuario fijo
        if (task.getUser() == null) {
            User user = userService.findById(1L); // usuario por defecto
            task.setUser(user);
        }

        taskService.save(task);

        // Actualizar la lista de tareas para HTMX
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
    // Buscar tareas (opcional)
    // ==========================
    @GetMapping("/search")
    public String searchTasks(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String category,
                              @RequestParam(required = false) String state,
                              Model model) {

        model.addAttribute("tasks", taskService.search(name, category, state));
        return "fragments/task-list :: task-list";
    }
}
