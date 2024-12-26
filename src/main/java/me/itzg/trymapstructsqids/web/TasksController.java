package me.itzg.trymapstructsqids.web;

import me.itzg.trymapstructsqids.data.TaskRepository;
import me.itzg.trymapstructsqids.web.model.ListResponse;
import me.itzg.trymapstructsqids.web.model.TaskCreate;
import me.itzg.trymapstructsqids.web.model.TaskDto;
import me.itzg.trymapstructsqids.web.model.TaskMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final SqidMapper sqidMapper;

    public TasksController(TaskRepository taskRepository, TaskMapper taskMapper, SqidMapper sqidMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.sqidMapper = sqidMapper;
    }

    @GetMapping
    public ListResponse<TaskDto> list() {
        return ListResponse.of(
            taskMapper.toDtoList(
                taskRepository.findAll()
            )
        );
    }

    @PostMapping
    public TaskDto createTask(@RequestBody @Validated TaskCreate request) {
        return taskMapper.toDto(
            taskRepository.save(
                taskMapper.fromCreate(request)
            )
        );
    }

    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable("id") String id) {
        return taskMapper.toDto(
            taskRepository.findById(
                    sqidMapper.fromSqid(id)
                )
                .orElseThrow(NotFoundException::new)
        );
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") String id) {
        taskRepository.deleteById(
            sqidMapper.fromSqid(id)
        );
    }
}
