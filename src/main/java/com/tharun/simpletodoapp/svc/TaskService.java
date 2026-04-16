package com.tharun.simpletodoapp.svc;

import com.tharun.simpletodoapp.dto.TaskRequestDto;
import com.tharun.simpletodoapp.dto.TaskResponseDto;
import com.tharun.simpletodoapp.entity.Task;
import com.tharun.simpletodoapp.entity.TaskStatus;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    List<Task> getTasksByTaskStatus(TaskStatus taskStatus);

    Task getTaskById(long id);

    void updateTaskStatus(long id, TaskStatus status);

    void createTask(Task task);

    void clearAllTasks();
}
