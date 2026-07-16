package com.study.hello;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoResponse> getAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public TodoResponse getOne(@PathVariable Long id) {
        return todoService.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PostMapping
    public TodoResponse create(@RequestBody @Valid CreateTodoRequest request) {
        return todoService.create(request.title(), request.categoryId());
    }

    @PutMapping("/{id}")
    public TodoResponse update(@PathVariable Long id, @RequestBody @Valid UpdateTodoRequest request) {
        return todoService.update(id, request.title(), request.done())
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        if (!todoService.delete(id)) {
            throw new TodoNotFoundException(id);
        }
        return "삭제 완료";
    }

    // 실습용: 카테고리 생성
    @PostMapping("/categories")
    public Category createCategory(@RequestBody CreateTodoRequest request) {
        return todoService.createCategory(request.title());
    }
}