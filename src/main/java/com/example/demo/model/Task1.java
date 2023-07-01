package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Task1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String task;
    @Column(name="student_id")
    private Long studentId;
    private LocalDate date;
    private Boolean done;
}
