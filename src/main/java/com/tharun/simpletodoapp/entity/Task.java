package com.tharun.simpletodoapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name="task_desc", nullable = false)
    private String taskDescription;

    @Column(name="task_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

}
