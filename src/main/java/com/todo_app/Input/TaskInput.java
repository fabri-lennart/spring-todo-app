package com.todo_app.Input;

public class TaskInput {

    private String taskName;
    private String description;
    private String priority;  // ⚠️ Este estaba faltando

    // Getters y setters
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
