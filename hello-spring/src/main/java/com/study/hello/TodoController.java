package com.study.hello;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    // Day1: 생성자 주입 — 스프링이 TodoService를 넣어줌
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Todo getOne(@PathVariable Long id) {
        return todoService.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));   // Step 2에서 만듦
    }

    @PostMapping
    public Todo create(@Valid @RequestBody CreateTodoRequest request) {
        return todoService.create(request.title());
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody UpdateTodoRequest request) {
        return todoService.update(id, request.title(), request.done())
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean removed = todoService.delete(id);
        if (!removed) {
            throw new TodoNotFoundException(id);
        }
        return "삭제 완료";
    }
}