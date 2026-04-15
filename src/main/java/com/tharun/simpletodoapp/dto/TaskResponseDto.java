package com.tharun.simpletodoapp.dto;

import lombok.Data;

@Data
public class TaskResponseDto {
    private Long id;
    private String name;
    private String description;
    private String status;
}
