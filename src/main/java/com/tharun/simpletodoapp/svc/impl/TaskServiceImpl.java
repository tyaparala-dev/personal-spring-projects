package com.tharun.simpletodoapp.svc.impl;

import com.tharun.simpletodoapp.dto.TaskRequestDto;
import com.tharun.simpletodoapp.dto.TaskResponseDto;
import com.tharun.simpletodoapp.entity.Task;
import com.tharun.simpletodoapp.entity.TaskStatus;
import com.tharun.simpletodoapp.repository.TaskRepository;
import com.tharun.simpletodoapp.svc.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByTaskStatus(TaskStatus taskStatus) {
        return taskRepository.findByTaskStatus(taskStatus);
    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateTaskStatus(long id, TaskStatus status) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null){
            task.setTaskStatus(status);
            taskRepository.save(task);
            return true;
        }
        return false;
    }

    @Override
    public void createTask(Task task){
        taskRepository.save(task);
    }

    @Override
    public void clearAllTasks() {
        taskRepository.deleteAll();
    }

    @Override
    public TaskResponseDto convertToDto(Task task){
        if (task == null){
            return null;
        }
        TaskResponseDto dto = new TaskResponseDto();
        dto.setId(task.getId());
        dto.setName(task.getTaskName());
        dto.setDescription(task.getTaskDescription());
        dto.setStatus(task.getTaskStatus().toString());
        return dto;
    }

    @Override
    public Task convertToDomain(TaskRequestDto dto){
        Task task = new Task();
        task.setTaskName(dto.getName());
        task.setTaskDescription(dto.getDescription());
        task.setTaskStatus(TaskStatus.OPEN);
        return task;
    }
}
