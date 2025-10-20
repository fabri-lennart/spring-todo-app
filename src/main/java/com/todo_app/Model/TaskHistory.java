package com.todo_app.Model;

import com.todo_app.Enum.CategoryType;
import com.todo_app.Enum.State;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks_history")
public class TaskHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_id", nullable = false)
    private Long taskId; // Referencia al ID original de la tarea

    @Column(name = "task_name", nullable = false, length = 150)
    private String taskName;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "final_date", nullable = false)
    private LocalDateTime finalDate;

    @Column(nullable = false, length = 150)
    private String priority;

    @Column(name = "user_id")
    private Long userId; // Solo guardamos el ID del usuario

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryType category = CategoryType.General;

    @Enumerated(EnumType.STRING)
    private State state = State.Pending;

    @Column(name = "history_timestamp", nullable = false)
    private LocalDateTime historyTimestamp; // Cuándo se guardó en el histórico

    // === Constructores ===
    public TaskHistory() {
        this.historyTimestamp = LocalDateTime.now();
    }

    // === Getters y Setters ===
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDateTime finalDate) {
        this.finalDate = finalDate;
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

    public LocalDateTime getHistoryTimestamp() {
        return historyTimestamp;
    }

    public void setHistoryTimestamp(LocalDateTime historyTimestamp) {
        this.historyTimestamp = historyTimestamp;
    }
}