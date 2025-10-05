package com.todo_app.Controller;

import com.todo_app.Input.TaskInput;
import com.todo_app.Model.Task;
import com.todo_app.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<Task> create(@RequestBody TaskInput input) {
        try {
            Task task = taskService.create(input);
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Error en caso de usuario no encontrado o categoría inválida
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
