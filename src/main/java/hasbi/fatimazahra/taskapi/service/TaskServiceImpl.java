package hasbi.fatimazahra.taskapi.service;

import hasbi.fatimazahra.taskapi.dtos.TaskDTO;
import hasbi.fatimazahra.taskapi.entities.Task;
import hasbi.fatimazahra.taskapi.mappers.TaskMappers;
import hasbi.fatimazahra.taskapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMappers taskMappers;
    @Override
    public TaskDTO save(TaskDTO taskDTO){
        Task task = taskMappers.fromTaskDTO(taskDTO);
        Task savedTask = taskRepository.save(task);
        return taskMappers.fromTask(savedTask);
    }
    @Override
    public List<TaskDTO> listTasks(){
        List<Task> tasks =taskRepository.findAll();
        List<TaskDTO> productDTOS=
                tasks.stream().map(p-> taskMappers.fromTask(p))
                        .collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public TaskDTO getTask(int id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Task not found"));
        return taskMappers.fromTask(task);
    }

    @Override
    public TaskDTO updateTask(TaskDTO productDTO) {
        Task task = taskMappers.fromTaskDTO(productDTO);
        Task saved = taskRepository.save(task);
        return taskMappers.fromTask(saved);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

}
