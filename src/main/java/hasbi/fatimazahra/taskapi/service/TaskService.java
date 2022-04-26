package hasbi.fatimazahra.taskapi.service;

import hasbi.fatimazahra.taskapi.dtos.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO save(TaskDTO taskDTO);

    List<TaskDTO> listTasks();

    TaskDTO getTask(int id);

    TaskDTO updateTask(TaskDTO taskDTO);

    void  deleteTask(int id);
}
