package com.example.demo.Controller;

import com.example.demo.Entity.Task;
import com.example.demo.Repositary.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repo;

    @GetMapping
    public List<Task> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return repo.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}