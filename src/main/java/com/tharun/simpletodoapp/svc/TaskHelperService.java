package com.tharun.simpletodoapp.svc;

import com.tharun.simpletodoapp.dto.TaskRequestDto;
import com.tharun.simpletodoapp.dto.TaskResponseDto;
import com.tharun.simpletodoapp.entity.Task;

public interface TaskHelperService {

    TaskResponseDto convertToDto(Task task);

    Task convertToDomain(TaskRequestDto dto);

}
