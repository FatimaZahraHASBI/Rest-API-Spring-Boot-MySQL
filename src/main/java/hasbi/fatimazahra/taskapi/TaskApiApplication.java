package hasbi.fatimazahra.taskapi;

import hasbi.fatimazahra.taskapi.entities.Task;
import hasbi.fatimazahra.taskapi.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class TaskApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskApiApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(TaskRepository taskRepository){
        return args -> {
            Stream.of("Analyse", "Conception", "Développement", "Sport", "Payer factures").forEach(name->{
                Task task =new Task();
                task.setName(name);
                taskRepository.save(task);
            });
        };
    }
}
