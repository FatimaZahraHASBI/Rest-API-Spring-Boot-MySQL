package hasbi.fatimazahra.taskapi.mappers;

import hasbi.fatimazahra.taskapi.dtos.TaskDTO;
import hasbi.fatimazahra.taskapi.entities.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TaskMappers {
    public TaskDTO fromTask(Task task){
        TaskDTO taskDTO = new TaskDTO();
        BeanUtils.copyProperties(task, taskDTO);
        return taskDTO;
    }

    public Task fromTaskDTO(TaskDTO taskDTO){
        Task task = new Task();
        BeanUtils.copyProperties(taskDTO, task);
        return task;
    }
}
