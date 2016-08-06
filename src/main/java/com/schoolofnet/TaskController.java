package com.schoolofnet;

import com.schoolofnet.model.Task;
import com.schoolofnet.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository repository;

    public TaskController(TaskRepository taskRepository) {
        this.repository = taskRepository;
    }

    @RequestMapping("/")
    @ResponseBody
    List<Task> home() {
        return repository.findAllByOrderByNameAsc();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    @ResponseBody
    Task create(String name) {
        Task task = new Task(name);

        repository.save(task);

        return task;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    Task update(@PathVariable Long id, String name) {
        Task task = repository.findOne(id);

        task.setName(name);

        repository.save(task);

        return task;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    void destroy(@PathVariable Long id) {
        repository.deleteAll();
    }
}
