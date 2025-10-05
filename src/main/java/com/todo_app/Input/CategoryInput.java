package com.todo_app.Input;

public class CategoryInput {
    private String name;
    private Long userId;  // agregar para asignar la categoría a un usuario

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
