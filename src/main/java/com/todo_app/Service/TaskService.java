package com.todo_app.Service;

import com.todo_app.Enum.CategoryType;
import com.todo_app.Input.TaskInput;
import com.todo_app.Model.Task;
import com.todo_app.Model.User;
import com.todo_app.Repository.TaskRepository;
import com.todo_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Task create(TaskInput input) {
        Task task = new Task();
        task.setTask_name(input.getTask_name());
        task.setDescription(input.getDescription());
        task.setCreated_date(input.getCreated_date());
        task.setFinal_date(input.getFinal_date());
        task.setPriority(input.getPriority());
        task.setState(input.getState());

        // Buscar el usuario por ID
        User user = userRepository.findById(input.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id " + input.getUserId()));
        task.setUser(user);

        // Asignar la categoría directamente desde el enum, con valor por defecto General si es null
        CategoryType category = input.getCategory() != null ? input.getCategory() : CategoryType.General;
        task.setCategory(category);

        return taskRepository.save(task);
    }
}
