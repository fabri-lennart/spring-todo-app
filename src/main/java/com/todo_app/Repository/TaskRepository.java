package com.todo_app.Repository;

import com.todo_app.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t " +
            "WHERE (:name IS NULL OR LOWER(t.taskName) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:category IS NULL OR t.category = :category) " +
            "AND (:state IS NULL OR t.state = :state)")
    List<Task> findByFilters(@Param("name") String name,
                             @Param("category") String category,
                             @Param("state") String state);
}
