package com.todo_app.Repository;

import com.todo_app.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Método para buscar con filtros (ya lo tienes)
    @Query("SELECT t FROM Task t WHERE " +
            "(:name IS NULL OR t.taskName LIKE %:name%) AND " +
            "(:category IS NULL OR t.category = :category) AND " +
            "(:state IS NULL OR t.state = :state)")
    List<Task> findByFilters(@Param("name") String name,
                             @Param("category") String category,
                             @Param("state") String state);

    // El método deleteById ya viene de JpaRepository, pero si necesitas uno personalizado:
    void deleteById(Long id);
}