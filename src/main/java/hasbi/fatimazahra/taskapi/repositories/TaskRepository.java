package hasbi.fatimazahra.taskapi.repositories;

import hasbi.fatimazahra.taskapi.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Integer> {
}
