package app.nus.taskapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);


    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

    @PostMapping
    public Task createTask(@RequestBody Task newTask) {
        if (newTask.getTitle() == null || newTask.getTitle().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Titolo obbligatorio");
        }
        newTask.setId(counter.incrementAndGet());
        tasks.add(newTask);

        log.info("Creazione nuovo task: {}", newTask.getTitle());

        return ResponseEntity.status(HttpStatus.CREATED).body(newTask).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id) {
        boolean removed = tasks.removeIf(t -> t.getId() == id);
        return removed ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task updated) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setTitle(updated.getTitle());
                t.setCompleted(updated.isCompleted());
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/sorted")
    public List<Task> getSortedTasks() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getTitle))
                .toList();
    }

    @GetMapping(params = "completed")
    public List<Task> getTasksByCompletion(@RequestParam boolean completed) {
        return tasks.stream()
                .filter(t -> t.isCompleted() == completed)
                .toList();
    }

    @GetMapping("/count")
    public Map<String, Object> getTaskCount() {
        return Map.of("totalTasks", tasks.size());
    }
}
