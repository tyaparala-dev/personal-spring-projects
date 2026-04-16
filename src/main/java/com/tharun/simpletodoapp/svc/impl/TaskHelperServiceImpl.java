package com.tharun.simpletodoapp.svc.impl;

import com.tharun.simpletodoapp.dto.TaskRequestDto;
import com.tharun.simpletodoapp.dto.TaskResponseDto;
import com.tharun.simpletodoapp.entity.Task;
import com.tharun.simpletodoapp.entity.TaskStatus;
import com.tharun.simpletodoapp.svc.TaskHelperService;
import org.springframework.stereotype.Service;

@Service
public class TaskHelperServiceImpl implements TaskHelperService {

    /*
     ************** Conversion Methods ****************
     */
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
