package com.todo_app.Repository;

import com.todo_app.Model.Task;
import com.todo_app.Enum.CategoryType;
import com.todo_app.Enum.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Método para buscar con filtros - VERSIÓN SIMPLIFICADA
    @Query("SELECT t FROM Task t WHERE " +
            "(:name IS NULL OR :name = '' OR t.taskName LIKE %:name%) AND " +
            "(:category IS NULL OR :category = '' OR t.category = :category) AND " +
            "(:state IS NULL OR :state = '' OR t.state = :state)")
    List<Task> findByFilters(@Param("name") String name,
                             @Param("category") CategoryType category,
                             @Param("state") State state);

    void deleteById(Long id);
}