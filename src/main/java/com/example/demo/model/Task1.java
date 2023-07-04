package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Task1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;
    private LocalDate date;
    private Boolean done = Boolean.FALSE;
    @Column(name="student_id")
    private Long studentId;
}
