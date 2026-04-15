package com.tharun.simpletodoapp.controller;

import com.tharun.simpletodoapp.dto.TaskRequestDto;
import com.tharun.simpletodoapp.dto.TaskResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tasks")
public interface TaskController {

    @GetMapping
    List<TaskResponseDto> getTasksByStatus(@RequestParam(required = false) String status);

    @GetMapping("/{id}")
    TaskResponseDto getTaskById(@PathVariable long id);

    @PostMapping
    void createTask(@RequestBody TaskRequestDto taskRequestDto);

    @PostMapping("/{id}/status/{status}")
    void updateTaskStatus(@PathVariable long id, @PathVariable  String status);

    @DeleteMapping
    void clearAllTasks();

}
