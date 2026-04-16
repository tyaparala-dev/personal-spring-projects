package com.tharun.simpletodoapp.svc.impl;

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
    public Task getTaskById(long id){
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> getTasksByTaskStatus(TaskStatus taskStatus){
        return taskRepository.findByTaskStatus(taskStatus);
    }

    @Override
    public void updateTaskStatus(long id, TaskStatus taskStatus){
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null){
            task.setTaskStatus(taskStatus);
            taskRepository.save(task);
        }
    }

    @Override
    public void createTask(Task task){
        taskRepository.save(task);
    }

    @Override
    public void clearAllTasks(){
        taskRepository.deleteAll();
    }

}
