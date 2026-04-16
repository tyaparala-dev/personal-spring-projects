package com.tharun.simpletodoapp.controller.impl;

import com.tharun.simpletodoapp.controller.TaskController;
import com.tharun.simpletodoapp.dto.TaskRequestDto;
import com.tharun.simpletodoapp.dto.TaskResponseDto;
import com.tharun.simpletodoapp.entity.TaskStatus;
import com.tharun.simpletodoapp.svc.TaskHelperService;
import com.tharun.simpletodoapp.svc.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;
    private final TaskHelperService taskHelperService;

    @Override
    public List<TaskResponseDto> getTasksByStatus(String status) {
        if (status == null){
            return taskService.getAllTasks().stream().map(taskHelperService::convertToDto).toList();
        }
        return taskService.getTasksByTaskStatus(TaskStatus.valueOf(status))
                .stream().map(taskHelperService::convertToDto).toList();
    }

    @Override
    public TaskResponseDto getTaskById(long id) {
        return taskHelperService.convertToDto(taskService.getTaskById(id));
    }

    @Override
    public void createTask(TaskRequestDto taskRequestDto) {
        taskService.createTask(taskHelperService.convertToDomain(taskRequestDto));
    }

    @Override
    public void updateTaskStatus(long id, String status) {
        taskService.updateTaskStatus(id, TaskStatus.valueOf(status));
    }

    @Override
    public void clearAllTasks() {
        taskService.clearAllTasks();
    }
}
