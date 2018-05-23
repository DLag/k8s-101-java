package com.example.todomgr.web;

import com.example.todomgr.model.Todo;
import com.example.todomgr.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepo;

    @GetMapping
    public Iterable<Todo> findAll() {
        return todoRepo.findAll();
    }

    @PostMapping
    public void create(@RequestBody Todo todo) {
        todoRepo.create(todo);
    }

    @GetMapping("/{id}")
    public Todo findById(@PathVariable String id) {
        return todoRepo.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Todo todo) {
        todoRepo.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        todoRepo.delete(id);
    }


}

