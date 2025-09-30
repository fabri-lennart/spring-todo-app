package com.todo_app.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="passwords")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 150)
    private String hash;
    @Column(unique = true, nullable = false, length = 150)
    private LocalDate create_at;
    @Column(unique = true, nullable = false, length = 150)
    private LocalDate update_at;



}
