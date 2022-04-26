package hasbi.fatimazahra.taskapi.web;

import hasbi.fatimazahra.taskapi.dtos.TaskDTO;
import hasbi.fatimazahra.taskapi.entities.Task;
import hasbi.fatimazahra.taskapi.repositories.TaskRepository;
import hasbi.fatimazahra.taskapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskRestController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/tasks")
    public List<TaskDTO> taskList(){
        return taskService.listTasks();
    }

    @GetMapping(path = "/tasks/{id}")
    public Task getTask(@PathVariable(name = "id") int id){
        return taskRepository.findById(id).get();
    }

    @PostMapping("/tasks")
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO){
        return taskService.save(taskDTO);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable int id){
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void daleteTask(@PathVariable int id){
        taskRepository.deleteById(id);
    }

}
