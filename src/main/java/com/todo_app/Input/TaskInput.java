package com.todo_app.Input;

import com.todo_app.Enum.CategoryType;
import com.todo_app.Enum.State;

import java.time.LocalDateTime;

public class TaskInput {
    private String task_name;
    private String description;
    private LocalDateTime created_date;
    private LocalDateTime final_date;
    private String priority;
    private Long userId;
    private CategoryType category = CategoryType.General; // enum categoría con valor por defecto
    private State state;

    // Getters y setters

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getFinal_date() {
        return final_date;
    }

    public void setFinal_date(LocalDateTime final_date) {
        this.final_date = final_date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
